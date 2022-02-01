import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class qnw
  extends qjh
{
  qnw(qnv paramqnv) {}
  
  public void onDestroy()
  {
    super.onDestroy();
    qnv.a(this.this$0).destroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (ayxa.hasNotchInScreenByVersion(this.this$0.getActivity()))
    {
      LinearLayout localLinearLayout = (LinearLayout)this.this$0.a().mItemView.findViewById(2131363674);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.height = qnv.a(this.this$0);
      if (!ankt.bA(this.this$0.mItemView.getContext())) {
        localLinearLayout.setBackgroundColor(Color.parseColor("#181818"));
      }
      localLinearLayout.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qnw
 * JD-Core Version:    0.7.0.1
 */