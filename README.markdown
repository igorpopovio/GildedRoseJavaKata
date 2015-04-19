![Gilded Rose Kata](/banner.png)

# The Gilded Rose Kata

The **purpose of this project** is to **serve as a training ground for working
with legacy code**.

## How to get started

After cloning the repository, make sure you have the Java Development Kit
installed and added to the path environment variable. If so then you can run
the following commands:  
- `./gradlew idea` to generate the IntelliJ IDEA project which you can later
open  
- `./gradlew test` to run all the tests  
- `./gradlew jacoco` to generate the code coverage report  
- `./gradlew pitest` to generate the mutation test coverage report  

After running any of the last 3 commands check the `build/reports` directory.

When ready to do the kata read the instructions below and open the
`GildedRoseTest` class.  

**Good luck!**

## The story

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a
prime location in a prominent city ran by a friendly innkeeper named Allison.
We also buy and sell only the finest goods. Unfortunately, our goods are
constantly degrading in quality as they approach their sell by date. We have a
system in place that updates our inventory for us. It was developed by a
no-nonsense type named Leeroy, who has moved on to new adventures.  

**Your task is to add the new feature to our system so that we can begin
selling a new category of items.**  

## First an introduction to our system  

- All items have a `sellIn` value which denotes the number of days we have to sell the item  
- All items have a `quality` value which denotes how valuable the item is  
- At the end of each day our system lowers both values for every item  

## Challenges

Pretty simple, right? Well, this is where **it gets interesting**:  
- The `quality` of an item is never negative  
- The `quality` of an item is never more than 50  
- Once the sell by date has passed, `quality` degrades twice as fast  
- **Aged Brie** actually increases in `quality` the older it gets  
- **Sulfuras**, being a legendary item, never has to be sold or decreases in
`quality`  
- **Backstage passes**, like aged brie, increases in `quality` as it’s `sellIn`
value approaches; `quality` increases by 2 when there are 10 days or less and
by 3 when there are 5 days or less but drops to 0 after the concert

## New requirements

We have recently signed a supplier of conjured items. This requires an update
to our system:  
- **Conjured** items degrade in `quality` twice as fast as normal items  

## Extra notes

Feel free to make any changes to the `updateQuality` method and add any new
code **as long as everything still works correctly**.  

However, **do not alter the `Item` class or `items` field** as those belong to
the goblin in the corner who will insta-rage and one-shot you as he doesn’t
believe in shared code ownership (you can make the `updateQuality` method and
    `items` field static if you like, we’ll cover for you).

