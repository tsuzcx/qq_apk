package android.support.v4.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

class FragmentTabHost$DummyTabFactory
  implements TabHost.TabContentFactory
{
  private final Context mContext;
  
  public FragmentTabHost$DummyTabFactory(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public View createTabContent(String paramString)
  {
    paramString = new View(this.mContext);
    paramString.setMinimumWidth(0);
    paramString.setMinimumHeight(0);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost.DummyTabFactory
 * JD-Core Version:    0.7.0.1
 */