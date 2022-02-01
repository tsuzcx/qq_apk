import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;

class vlm
  extends RecyclerView.OnScrollListener
{
  vlm(vll paramvll, String paramString1, String paramString2) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    TextView localTextView;
    if ((this.jdField_a_of_type_Vll.a().a() instanceof zyi))
    {
      paramInt1 = ((zyi)this.jdField_a_of_type_Vll.a().a()).findFirstVisibleItemPosition();
      if ((vll.a(this.jdField_a_of_type_Vll) != paramInt1) && (vll.a(this.jdField_a_of_type_Vll) != null))
      {
        localTextView = vll.a(this.jdField_a_of_type_Vll);
        if (paramInt1 <= 1) {
          break label89;
        }
      }
    }
    label89:
    for (paramRecyclerView = this.jdField_a_of_type_JavaLangString;; paramRecyclerView = this.b)
    {
      localTextView.setText(paramRecyclerView);
      vll.a(this.jdField_a_of_type_Vll, paramInt1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlm
 * JD-Core Version:    0.7.0.1
 */