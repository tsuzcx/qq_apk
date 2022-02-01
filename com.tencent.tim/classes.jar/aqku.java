import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aqku
  extends aqju
{
  TextView Dp;
  int dZI;
  RelativeLayout mt;
  RelativeLayout mu;
  RelativeLayout mv;
  
  public aqku(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.dZI = wja.dp2px(35.0F, paramContext.getResources());
  }
  
  public void UP(String paramString)
  {
    this.title.setVisibility(8);
    this.mt.setVisibility(0);
    ((TextView)this.mt.findViewById(2131381161)).setText(paramString);
  }
  
  public float a(Activity paramActivity, float paramFloat)
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    float f2 = localDisplay.getWidth();
    int i = paramActivity.getResources().getDimensionPixelSize(2131297117);
    float f1 = paramFloat;
    if (i > f2 * paramFloat)
    {
      f2 = i / localDisplay.getWidth();
      f1 = paramFloat;
      if (f2 > paramFloat)
      {
        f1 = paramFloat;
        if (f2 < 1.0D) {
          f1 = f2;
        }
      }
    }
    return f1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    QLog.i("Forward.Dialog", 1, "uin: " + paramString1 + " uinType: " + paramInt + " titleStr: " + paramString2);
    this.mt.setVisibility(0);
    this.title.setVisibility(8);
    this.mv.setVisibility(8);
    this.mu.setVisibility(0);
    this.Dp.setText(paramString2);
    ImageView localImageView1 = (ImageView)this.mt.findViewById(2131369092);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.mt.findViewById(2131379810);
    ImageView localImageView2 = (ImageView)this.mt.findViewById(2131369090);
    aqkv localaqkv = new aqkv(this, paramQQAppInterface, paramString2, paramString1, paramInt);
    paramActivity = new aqkw(this, paramInt, paramQQAppInterface, paramActivity, paramString1, paramString2);
    if ((paramInt == 0) || (paramInt == 1000))
    {
      localImageView1.setImageDrawable(aqdj.a(paramQQAppInterface, 1, paramString1));
      this.mu.setOnClickListener(paramActivity);
      this.mu.setBackgroundResource(2130840508);
      return;
    }
    if (paramInt == 1)
    {
      if (paramBoolean) {}
      for (paramQQAppInterface = aqdj.a(paramQQAppInterface, 113, paramString1);; paramQQAppInterface = aqdj.a(paramQQAppInterface, 4, paramString1))
      {
        localImageView1.setImageDrawable(paramQQAppInterface);
        localImageView1.setOnClickListener(localaqkv);
        localRelativeLayout.setOnClickListener(paramActivity);
        localRelativeLayout.setBackgroundResource(2130840508);
        return;
      }
    }
    if (paramInt == 3000)
    {
      localImageView1.setImageDrawable(aqdj.a(paramQQAppInterface, 101, paramString1));
      localImageView1.setOnClickListener(localaqkv);
      localRelativeLayout.setOnClickListener(paramActivity);
      localRelativeLayout.setBackgroundResource(2130840508);
      return;
    }
    if (paramInt == 1006)
    {
      localImageView1.setImageDrawable(aqdj.a(paramQQAppInterface, 11, paramString1));
      this.mu.setOnClickListener(paramActivity);
      this.mu.setBackgroundResource(2130840508);
      return;
    }
    if (acbn.bkw.equals(paramString1))
    {
      localImageView1.setImageResource(2130845074);
      localImageView1.setOnClickListener(localaqkv);
      this.mu.setOnClickListener(paramActivity);
      this.mu.setBackgroundResource(2130840508);
      return;
    }
    if (acbn.bkx.equals(paramString1))
    {
      localImageView1.setImageResource(2130845071);
      localImageView1.setOnClickListener(localaqkv);
      this.mu.setOnClickListener(paramActivity);
      this.mu.setBackgroundResource(2130840508);
      return;
    }
    localImageView2.setVisibility(8);
    localImageView1.setImageDrawable(aqdj.g(1, 1));
  }
  
  @TargetApi(16)
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ResultRecord> paramList, boolean paramBoolean)
  {
    this.mt.setVisibility(0);
    this.mv.setVisibility(0);
    this.title.setVisibility(8);
    this.mu.setVisibility(8);
    ((TextView)this.mt.findViewById(2131381161)).setText(acfp.m(2131711607));
    GridView localGridView = (GridView)this.mt.findViewById(2131368286);
    localGridView.setNumColumns(5);
    localGridView.setHorizontalSpacing((wja.dp2px(236.0F, getContext().getResources()) - this.dZI * 5) / 5);
    localGridView.setVerticalSpacing(wja.dp2px(10.0F, getContext().getResources()));
    Object localObject = (RelativeLayout.LayoutParams)localGridView.getLayoutParams();
    if (Build.VERSION.SDK_INT >= 16) {}
    for (int i = localGridView.getVerticalSpacing();; i = 0)
    {
      if (paramList.size() <= 5) {}
      for (((RelativeLayout.LayoutParams)localObject).height = this.dZI;; ((RelativeLayout.LayoutParams)localObject).height = (i + this.dZI * 2))
      {
        localGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localGridView.setFocusable(false);
        localObject = null;
        if (paramBoolean) {
          localObject = new aqkx(this, paramActivity);
        }
        localGridView.setAdapter(new aqku.a(paramQQAppInterface, getContext(), paramList, (View.OnClickListener)localObject));
        return;
      }
    }
  }
  
  public void dismiss()
  {
    if (hasPreViewInDialog())
    {
      removePreviewView();
      return;
    }
    super.dismiss();
  }
  
  public void eee()
  {
    if (this.mv == null) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mv.getLayoutParams();
    localMarginLayoutParams.topMargin = wja.dp2px(2.0F, getContext().getResources());
    this.mv.setLayoutParams(localMarginLayoutParams);
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.mt = ((RelativeLayout)findViewById(2131377496));
    this.Dp = ((TextView)this.mt.findViewById(2131381164));
    this.mu = ((RelativeLayout)this.mt.findViewById(2131368425));
    this.mv = ((RelativeLayout)this.mt.findViewById(2131368426));
  }
  
  class a
    extends BaseAdapter
  {
    private List<ResultRecord> IP;
    private QQAppInterface mApp;
    private Context mContext;
    private View.OnClickListener x;
    
    public a(Context paramContext, List<ResultRecord> paramList, View.OnClickListener paramOnClickListener)
    {
      this.mApp = paramContext;
      this.mContext = paramList;
      Object localObject;
      this.x = localObject;
      this.IP = paramOnClickListener;
    }
    
    private void a(ImageView paramImageView, ResultRecord paramResultRecord)
    {
      if (acbn.bkw.equals(paramResultRecord.uin))
      {
        paramImageView.setImageResource(2130845074);
        return;
      }
      if (acbn.bkx.equals(paramResultRecord.uin))
      {
        paramImageView.setImageResource(2130845071);
        return;
      }
      if (acbn.bky.equals(paramResultRecord.uin))
      {
        paramImageView.setImageResource(2130845077);
        return;
      }
      if (acbn.bkv.equals(paramResultRecord.uin))
      {
        paramImageView.setImageResource(2130840081);
        return;
      }
      int i = eR(paramResultRecord.lk());
      paramImageView.setImageDrawable(aqdj.a(this.mApp, i, paramResultRecord.uin));
    }
    
    private int eR(int paramInt)
    {
      if (paramInt == 4) {}
      do
      {
        return 11;
        if (paramInt == 1) {
          return 4;
        }
        if (paramInt == 3000) {
          return 101;
        }
      } while (paramInt == 1006);
      return 1;
    }
    
    public ResultRecord a(int paramInt)
    {
      return (ResultRecord)this.IP.get(paramInt);
    }
    
    public int getCount()
    {
      if (this.IP == null) {
        return 0;
      }
      return this.IP.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ImageView localImageView;
      if (paramView == null)
      {
        localImageView = new ImageView(this.mContext);
        localImageView.setLayoutParams(new AbsListView.LayoutParams(aqku.this.dZI, aqku.this.dZI));
      }
      for (;;)
      {
        a(localImageView, a(paramInt));
        localImageView.setTag(a(paramInt));
        localImageView.setOnClickListener(this.x);
        localImageView.setFocusable(false);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localImageView;
        localImageView = (ImageView)paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqku
 * JD-Core Version:    0.7.0.1
 */