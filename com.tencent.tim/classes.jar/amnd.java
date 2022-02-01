import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.a;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;

public class amnd
  implements ReadInJoySearchTipsContainer.a
{
  public amnd(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void of(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      FragmentActivity localFragmentActivity = this.this$0.getActivity();
      if ((localFragmentActivity instanceof ActiveEntitySearchActivity))
      {
        ((ActiveEntitySearchActivity)localFragmentActivity).PL(paramString);
        if (this.this$0.as != null) {
          amxk.b("sub_result", "clk_hot", new String[] { paramString, amxk.c(this.this$0.as) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnd
 * JD-Core Version:    0.7.0.1
 */