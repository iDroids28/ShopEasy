package com.example.shopeasy

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Top overlay buttons
        val btnShopNow = findViewById<ImageButton>(R.id.btnShopNow)
        val btnBecomeSeller = findViewById<ImageButton>(R.id.btnBecomeSeller)

        btnShopNow.setOnClickListener {
            Toast.makeText(this, "Shop Now clicked", Toast.LENGTH_SHORT).show()
        }
        btnBecomeSeller.setOnClickListener {
            Toast.makeText(this, "Become a Seller clicked", Toast.LENGTH_SHORT).show()
        }

        // Horizontal scroll categories
        val scrollView: HorizontalScrollView = findViewById(R.id.horizontalScrollView)
        val categoryContainer: LinearLayout = findViewById(R.id.categoryContainer)

        val categories = listOf(
            Pair(R.drawable.pic1, "Vegetable"),
            Pair(R.drawable.pic2, "Chicken & Poultry"),
            Pair(R.drawable.pic3, "Rice")
        )

        val imageWidth = 150.dp
        val imageHeight = 120.dp
        val spacing = 16.dp
        val screenWidth = resources.displayMetrics.widthPixels
        val leftPadding = (screenWidth / 2) - (imageWidth / 2)

        categoryContainer.addView(View(this).apply {
            layoutParams = LinearLayout.LayoutParams(leftPadding, LinearLayout.LayoutParams.MATCH_PARENT)
        })

        for ((imgRes, label) in categories) {
            val itemLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER_HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(spacing, 0, spacing, 0)
                }
            }

            val imageView = ImageView(this).apply {
                setImageResource(imgRes)
                layoutParams = LinearLayout.LayoutParams(imageWidth, imageHeight)
                scaleType = ImageView.ScaleType.CENTER_CROP
                setOnClickListener {
                    Toast.makeText(this@MainActivity2, "Clicked $label", Toast.LENGTH_SHORT).show()
                }
            }

            val textView = TextView(this).apply {
                text = label
                setTextColor(Color.BLACK)
                textSize = 14f
                gravity = Gravity.CENTER
            }

            itemLayout.addView(imageView)
            itemLayout.addView(textView)
            categoryContainer.addView(itemLayout)
        }

        categoryContainer.addView(View(this).apply {
            layoutParams = LinearLayout.LayoutParams(leftPadding, LinearLayout.LayoutParams.MATCH_PARENT)
        })

        scrollView.post { scrollView.scrollTo(leftPadding, 0) }

        // Bestseller 2x2 vertical grid
        val gridContainer = findViewById<GridLayout>(R.id.gridContainer)
        gridContainer.removeAllViews()

        val bestsellerItems = listOf(
            BestsellerItem(R.drawable.bs1, "Chicken", "⭐⭐⭐⭐☆ 4.5", "₱200 - ₱250", "Dagupan City"),
            BestsellerItem(R.drawable.bs2, "Corn", "⭐⭐⭐⭐ 4.0", "₱15 - ₱25", "Mangaldan"),
            BestsellerItem(R.drawable.bs3, "Mushroom", "⭐⭐⭐⭐⭐ 5.0", "₱130 - ₱150", "Binmaley"),
            BestsellerItem(R.drawable.bs4, "Bulk Rice", "⭐⭐⭐⭐ 4.0", "₱50 - ₱70", "Calasiao")
        )

        for (item in bestsellerItems) {
            val itemLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(16.dp, 16.dp, 16.dp, 16.dp)
                }
            }

            val imageView = ImageView(this).apply {
                setImageResource(item.imageRes)
                layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 120.dp)
                scaleType = ImageView.ScaleType.CENTER_CROP
            }

            val titleText = TextView(this).apply { 
                text = item.title
                textSize = 16f
                setTextColor(Color.BLACK)
                setPadding(0, 4.dp, 0, 0)
            }

            val ratingText = TextView(this).apply {
                text = item.rating
                textSize = 14f
                setTextColor(Color.DKGRAY)
                setPadding(0, 2.dp, 0, 0)
            }

            val priceText = TextView(this).apply {
                text = item.price
                textSize = 14f
                setTextColor(Color.BLACK) // price now black
                setPadding(0, 2.dp, 0, 0)

        }

            val locationText = TextView(this).apply {
                text = item.location
                textSize = 14f
                setTextColor(Color.DKGRAY)
                setPadding(0, 2.dp, 0, 0)
            }

            itemLayout.addView(imageView)
            itemLayout.addView(titleText)
            itemLayout.addView(ratingText)
            itemLayout.addView(priceText)
            itemLayout.addView(locationText)

            gridContainer.addView(itemLayout)
        }

        // Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.nav_home
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_cart -> { startActivity(Intent(this, CartActivity::class.java)); true }
                R.id.nav_notification -> { startActivity(Intent(this, NotificationActivity::class.java)); true }
                R.id.nav_profile -> { startActivity(Intent(this, ProfileActivity::class.java)); true }
                else -> false
            }
        }
    }

    // dp extension
    private val Int.dp: Int
        get() = (this * resources.displayMetrics.density).toInt()
}

// Bestseller data class
data class BestsellerItem(
    val imageRes: Int,
    val title: String,
    val rating: String,
    val price: String,
    val location: String
)



