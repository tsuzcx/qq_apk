import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;

class vnq
  extends RecyclerView.OnScrollListener
{
  vnq(vnp paramvnp, String paramString1, String paramString2) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    TextView localTextView;
    if ((this.jdField_a_of_type_Vnp.a().a() instanceof aace))
    {
      paramInt1 = ((aace)this.jdField_a_of_type_Vnp.a().a()).findFirstVisibleItemPosition();
      if ((vnp.a(this.jdField_a_of_type_Vnp) != paramInt1) && (vnp.a(this.jdField_a_of_type_Vnp) != null))
      {
        localTextView = vnp.a(this.jdField_a_of_type_Vnp);
        if (paramInt1 <= 1) {
          break label89;
        }
      }
    }
    label89:
    for (paramRecyclerView = this.jdField_a_of_type_JavaLangString;; paramRecyclerView = this.b)
    {
      localTextView.setText(paramRecyclerView);
      vnp.a(this.jdField_a_of_type_Vnp, paramInt1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnq
 * JD-Core Version:    0.7.0.1
 */