# API Demo with BottomNavigationView

The `BottomNavigationView` navigation comes with some default code to help you get started with your application development.

There are quite a few modifications that need to be made before having a working version of a `BottomNavigationView`. I'll try to explain these here.

## Fragments

I have removed all the fragments created by Android Studio and replaced them with two types of Fragments:

- Fragment with a ViewModel (`GlideFragment` and `PicassoFragment`)
- Blank Fragment (`VolleyFragment` and `RetrofitFragment`)

This is for you to see the differences in the implementation for these two types of Fragments.

For both types of Fragments, I have also deleted some code that was not needed in my application.

## bottom_nav_menu.xml

This file (situated in `res/menu`) is used to actually tell which buttons will be shown at the bottom of your screen.
I have thus modified this file to have a reference to my four fragments. Note the `id` given to each of these menu items: `navigation_picasso`, or `navigation_glide`, etc.

## mobile_navigation.xml

This file (situation in `res/navigation`) is used to make the link between your fragments and the menu items defined just previously in the `bottom_nav_menu.xml` file.
When adding the fragments, make sure to:

- Define the _start navigation_ fragment (which will be the first fragment to be displayed when launching your application);
- Reuse the same `id` as previously defined in the `bottom_nav_menu.xml` file.

## MainActivity.java

In this file, I have simply edited the following code to tell the `MainActivity` to use the several fragments defined in the previous steps.

``` java
AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        R.id.navigation_picasso, R.id.navigation_glide, R.id.navigation_volley, R.id.navigation_retrofit)
        .build();
```

With all this, I think that you should be able to have a working application, with four fragments. The logic of each fragment then has to be implemented in each `Fragment` class.