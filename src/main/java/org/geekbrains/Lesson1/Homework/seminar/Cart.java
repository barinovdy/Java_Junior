package org.geekbrains.Lesson1.Homework.seminar;

import org.geekbrains.Lesson1.Homework.seminar.common.interfaces.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food> {

    //region Методы

    /**
     * Балансировка корзины
     */
    public <F extends Food> void cartBalancing(Class<T> clazz) {

//        Map<Integer, PfcInterface<F>> methods = new HashMap<>();
//        methods.put(0, Food::getProteins);
//        methods.put(1, Food::getFats);
//        methods.put(2, Food::getCarbohydrates);

        boolean flalErr = false;

        if (foodstuffs.stream().noneMatch(Food::getProteins)) {
            var thing = market.getThings(clazz).stream()
                    .filter(Food::getProteins)
                    .findFirst()
                    .orElse(null);
            if (thing != null)
                    foodstuffs.add(thing);
            else
                flalErr = true;
        }
        if (foodstuffs.stream().noneMatch(Food::getFats)) {
            var thing = market.getThings(clazz).stream().filter(Food::getFats).findFirst().orElse(null);
            if (thing != null)
                foodstuffs.add(thing);
            else
                flalErr = true;
        }
        if (foodstuffs.stream().noneMatch(Food::getCarbohydrates)) {
            var thing = market.getThings(clazz).stream().filter(Food::getCarbohydrates).findFirst().orElse(null);
            if (thing != null)
                foodstuffs.add(thing);
            else
                flalErr = true;
        }

        if (flalErr)
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
        else
            System.out.println("Корзина сбалансирована по БЖУ.");
    }

    /**
     * Распечатать список товаров в корзине
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }
    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    //endregion

    //region Конструкторы
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }
    //endregion

    //region Поля
    private final UMarket market;
    private final ArrayList<T> foodstuffs;
    private final Class<T> clazz;
    //endregion
}