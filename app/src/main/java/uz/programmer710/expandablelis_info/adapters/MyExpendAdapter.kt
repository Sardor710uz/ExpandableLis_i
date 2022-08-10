package uz.programmer710.expandablelis_info.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.item_child.view.*
import kotlinx.android.synthetic.main.item_group.view.*
import uz.programmer710.expandablelis_info.R
import uz.programmer710.expandablelis_info.User

class MyExpendAdapter(
    private val context: Context,
    val map: HashMap<String, ArrayList<User>>,
    val titleList: ArrayList<String>
    ) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(context)
        val itemGroup = layoutInflater.inflate(R.layout.item_group, parent, false)
        itemGroup.tv_item_group.text = titleList[groupPosition]
        return itemGroup
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(context)
        val itemChild = layoutInflater.inflate(R.layout.item_child, parent, false)
        itemChild.tv_item_child.text = map[titleList[groupPosition]]?.get(childPosition)?.text
        itemChild.image_item_child.setImageResource(map[titleList[groupPosition]]?.get(childPosition)?.image!!)
        return itemChild
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}