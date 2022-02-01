import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;

public class apvf
{
  private ImageView EN;
  public final String TAG = "RobotMemberFormItem";
  private TextView abm;
  public final int dXk = 3;
  private int height;
  private TextView kK;
  private LinearLayout lb;
  private Context mContext;
  private View rootView;
  private int width;
  
  public apvf(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    init();
    LX(paramString);
  }
  
  private void init()
  {
    this.rootView = View.inflate(this.mContext, 2131561745, null);
    if (this.rootView != null)
    {
      this.abm = ((TextView)this.rootView.findViewById(2131370387));
      this.kK = ((TextView)this.rootView.findViewById(2131377328));
      this.lb = ((LinearLayout)this.rootView.findViewById(2131363199));
      this.EN = ((ImageView)this.rootView.findViewById(2131377002));
    }
    this.width = this.mContext.getResources().getDimensionPixelSize(2131299320);
    this.height = this.width;
  }
  
  public void LX(String paramString)
  {
    if (this.abm != null)
    {
      if (paramString != null) {
        this.abm.setText(paramString);
      }
    }
    else {
      return;
    }
    this.abm.setText("");
  }
  
  public void Sm(boolean paramBoolean)
  {
    if (this.EN != null)
    {
      if (paramBoolean) {
        this.EN.setVisibility(0);
      }
      for (;;)
      {
        QLog.d("RobotMemberFormItem", 2, "setRobotRedDot" + paramBoolean);
        return;
        this.EN.setVisibility(8);
      }
    }
    QLog.d("RobotMemberFormItem", 2, "mImgRobotRedDoterr");
  }
  
  public void a(AppInterface paramAppInterface, ArrayList<aptv> paramArrayList)
  {
    QLog.d("RobotMemberFormItem", 2, "setMemberUinList!");
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (this.kK != null)
      {
        this.kK.setText(this.mContext.getResources().getString(2131696353));
        this.kK.setVisibility(0);
        if (this.lb != null) {
          this.lb.setVisibility(8);
        }
      }
    }
    do
    {
      return;
      if (this.lb != null) {
        this.lb.removeAllViews();
      }
      int i = 0;
      while ((i < paramArrayList.size()) && (i < 3))
      {
        aptv localaptv = (aptv)paramArrayList.get(i);
        String str = String.valueOf(localaptv.getUin());
        Object localObject = aqhu.aU();
        localObject = aqdj.a(paramAppInterface, 1, str, 3, (Drawable)localObject, (Drawable)localObject, 4);
        ThemeImageView localThemeImageView = new ThemeImageView(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.width, this.height);
        localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131299321);
        if (localaptv.isOffline()) {
          ((aqdj)localObject).setAlpha(50);
        }
        localThemeImageView.setTag(localaptv);
        localThemeImageView.setLayoutParams(localLayoutParams);
        localThemeImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localThemeImageView.setBackgroundDrawable((Drawable)localObject);
        if (this.lb != null)
        {
          this.lb.addView(localThemeImageView);
          QLog.d("RobotMemberFormItem", 2, "add AvatarViews task  " + str);
        }
        i += 1;
      }
      if (this.lb != null) {
        this.lb.setVisibility(0);
      }
    } while (this.kK == null);
    this.kK.setVisibility(8);
  }
  
  public void destroy() {}
  
  public View getView()
  {
    return this.rootView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvf
 * JD-Core Version:    0.7.0.1
 */