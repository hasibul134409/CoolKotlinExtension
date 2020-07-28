import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

fun ViewGroup.inflateLayout(resourceId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(resourceId, this, attachToRoot)
}

val Any.TAG: String
    get() {
        val tag = javaClass.name
        return if(tag.length <= 23) tag else tag.substring(0, 23)
    }

fun Context.showToast(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT)
}

operator fun <T> MutableLiveData<ArrayList<T>>.plusAssign(listToUpdate: ArrayList<T>) {
    val value = this.value ?: arrayListOf()
    value.addAll(listToUpdate)
    this.value = value
}

class MarginItemDecoration(private var margin: Int): RecyclerView.ItemDecoration() {
    @Override
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = margin
        outRect.top = margin
        outRect.left = margin
        outRect.right = margin
    }
}