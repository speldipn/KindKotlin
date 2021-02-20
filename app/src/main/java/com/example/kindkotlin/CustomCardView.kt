package com.example.kindkotlin

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_card_item.view.*

class CustomCardView : LinearLayout {
   lateinit var itemView: View

   constructor(context: Context?) : super(context) {
      setup()
   }

   constructor(context: Context?, attributeSet: AttributeSet?): super(context, attributeSet) {
      setup()
   }

   private fun setup() {
      itemView = LayoutInflater.from(context).inflate(R.layout.custom_card_item, this, true)
   }

   fun setName(name:String) { itemView.nameTextView.text = name }

   fun setPhone(phone: String) { itemView.phoneTextView.text = phone }

   fun setProfileImage(resId: Int) {
       itemView.profileImageView.setImageDrawable(context.getDrawable(resId))
   }


}