package com.example.dogbreeds

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android21buttons.fragmenttestrule.FragmentTestRule
import com.example.dogbreeds.ui.adapter.BreedListAdapter
import com.example.dogbreeds.ui.view.fragment.BreedListFragment
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
class BreedListFragmentTest {

    @get:Rule
    var fragmentTestRule: FragmentTestRule<*, BreedListFragment> =
        FragmentTestRule.create(BreedListFragment::class.java)

    @Test
    fun scrollToTenthItem() {
        Espresso.onView(withId(R.id.breed_list))
            .perform(
                RecyclerViewActions.
                scrollToPosition<RecyclerView.ViewHolder>(10))
    }
}