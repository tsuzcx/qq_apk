package cooperation.qqfav.globalsearch;

import acfp;
import android.content.Context;
import android.content.Intent;
import avjs;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FavoriteSearchActivity
  extends BaseSearchActivity
{
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, FavoriteSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public BaseSearchFragment<avjs> a()
  {
    return new FavoriteSearchFragment();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((getIntent() != null) && (UniteSearchActivity.class.getSimpleName().equals(getIntent().getStringExtra("preAct")))) {
      overridePendingTransition(2130772004, 2130772005);
    }
  }
  
  public String vm()
  {
    return acfp.m(2131706112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchActivity
 * JD-Core Version:    0.7.0.1
 */