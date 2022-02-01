import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.mobileqq.widget.TabBarView2;
import java.util.HashMap;

public class ahdo
  implements TabBarView.a
{
  public ahdo(QfileTabBarView paramQfileTabBarView) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.b.d(paramInt2) == null) {}
    do
    {
      return;
      this.b.a.setSelected(true);
      this.b.hG(paramInt2);
    } while (!this.b.cgj);
    try
    {
      SharedPreferences.Editor localEditor = this.b.d.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_view", ((Integer)this.b.N.get(Integer.valueOf(paramInt2))).intValue());
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdo
 * JD-Core Version:    0.7.0.1
 */