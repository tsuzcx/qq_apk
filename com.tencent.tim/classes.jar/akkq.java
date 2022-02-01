import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class akkq
  extends ReportDialog
{
  protected akkq.b b;
  protected Drawable eY;
  protected Context mContext;
  protected int mImgHeight;
  protected int mImgWidth;
  protected View.OnClickListener mOnClickListener = new akkr(this);
  
  public akkq(Context paramContext, ArrayList<akkq.a> paramArrayList)
  {
    super(paramContext, 2131756467);
    this.mContext = paramContext;
    this.mImgHeight = aqcx.dip2px(paramContext, 34.0F);
    this.mImgHeight = aqcx.dip2px(paramContext, 34.0F);
    eD(paramArrayList);
  }
  
  public void a(akkq.b paramb)
  {
    this.b = paramb;
  }
  
  public void e(int paramInt1, int paramInt2, float paramFloat)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.x = paramInt1;
    localLayoutParams.y = paramInt2;
    localLayoutParams.gravity = 85;
    localLayoutParams.dimAmount = paramFloat;
    localWindow.setAttributes(localLayoutParams);
    super.show();
  }
  
  protected void eD(ArrayList<akkq.a> paramArrayList)
  {
    RoundCornerLinearLayout localRoundCornerLinearLayout = new RoundCornerLinearLayout(this.mContext);
    localRoundCornerLinearLayout.setOrientation(1);
    localRoundCornerLinearLayout.setBackgroundResource(2130846456);
    int i = aqcx.dip2px(this.mContext, 6.0F);
    localRoundCornerLinearLayout.setPadding(0, i, 0, i);
    localRoundCornerLinearLayout.setRadius(aqcx.dip2px(this.mContext, 8.0F));
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      akkq.a locala = (akkq.a)paramArrayList.next();
      ViewGroup localViewGroup = (ViewGroup)localLayoutInflater.inflate(2131559699, localRoundCornerLinearLayout, false);
      ImageView localImageView = (ImageView)localViewGroup.findViewById(2131368698);
      TextView localTextView1 = (TextView)localViewGroup.findViewById(2131379769);
      TextView localTextView2 = (TextView)localViewGroup.findViewById(2131378922);
      localTextView1.setText(locala.title);
      if (TextUtils.isEmpty(locala.subTitle))
      {
        localTextView2.setVisibility(8);
        label167:
        if (TextUtils.isEmpty(locala.iconUrl)) {
          break label227;
        }
        m(localImageView, locala.iconUrl);
      }
      for (;;)
      {
        localViewGroup.setOnClickListener(this.mOnClickListener);
        localViewGroup.setTag(locala);
        localRoundCornerLinearLayout.addView(localViewGroup);
        break;
        localTextView2.setText(locala.subTitle);
        break label167;
        label227:
        if (locala.iconResId > 0) {
          localImageView.setImageResource(locala.iconResId);
        }
      }
    }
    setContentView(localRoundCornerLinearLayout);
  }
  
  protected void m(ImageView paramImageView, String paramString)
  {
    if (this.eY == null) {
      this.eY = new ColorDrawable(Color.parseColor("#f2f2f2"));
    }
    Object localObject2 = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.mImgHeight;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.mImgWidth;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.eY;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.eY;
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      }
      for (;;)
      {
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = this.eY;
        }
        paramImageView.setImageDrawable(paramString);
        return;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyPublishMenu", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyPublishMenu", 2, "loadImage exp: url=" + paramString, localException);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static class a
  {
    public int iconResId;
    public String iconUrl;
    public int id;
    public String jumpUrl;
    public String subTitle;
    public String title;
  }
  
  public static abstract interface b
  {
    public abstract void a(Dialog paramDialog, View paramView, akkq.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkq
 * JD-Core Version:    0.7.0.1
 */