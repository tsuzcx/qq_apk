import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.mobileqq.intervideo.now.dynamic.LoadingFragment;

class aify
  implements CustomizedLoading
{
  aify(aifl paramaifl) {}
  
  public void onShowLoading(Context paramContext, Bundle paramBundle, View paramView)
  {
    LoadingFragment.a(paramContext, paramBundle, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aify
 * JD-Core Version:    0.7.0.1
 */