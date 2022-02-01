import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class jvq
  extends juh
{
  public jvq(Context paramContext, ArrayList<jzs.a> paramArrayList, jtw paramjtw, String paramString1, String paramString2)
  {
    super(paramContext, paramArrayList, paramjtw, paramString1, paramString2);
  }
  
  public static View a(Context paramContext, View paramView, ViewGroup paramViewGroup, jzs paramjzs, int paramInt, jtw paramjtw, String paramString1, String paramString2)
  {
    paramjzs = a(paramjzs, paramInt);
    if (paramjzs.isEmpty())
    {
      paramContext = paramView;
      if (QLog.isDevelopLevel())
      {
        QLog.d("AccountDetailWindowViewWrapper", 2, "createView return convertView!");
        paramContext = paramView;
      }
    }
    do
    {
      return paramContext;
      if ((paramView == null) || (!(paramView instanceof LinearLayout))) {
        break;
      }
      paramView = (LinearLayout)paramView;
      Object localObject = paramView.getTag();
      if ((localObject == null) || (!(localObject instanceof jvq)) || (!((jvq)localObject).q(paramjzs))) {
        break;
      }
      paramContext = paramView;
    } while (!QLog.isDevelopLevel());
    QLog.d("AccountDetailWindowViewWrapper", 2, "createView reuse!");
    return paramView;
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailWindowViewWrapper", 2, "createView new create!");
    }
    paramView = (LinearLayout)LayoutInflater.from(paramContext).inflate(2131558439, paramViewGroup, false);
    paramView.setPadding(0, wja.dp2px(20.0F, paramViewGroup.getResources()), 0, 0);
    paramContext = new jvq(paramContext, paramjzs, paramjtw, paramString1, paramString2);
    paramView.setTag(paramContext);
    paramContext.c(paramView);
    return paramView;
  }
  
  @TargetApi(9)
  private void c(LinearLayout paramLinearLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailWindowViewWrapper", 2, "buildView!");
    }
    Object localObject = this.mContext.getResources();
    int i = wja.dp2px(140.0F, (Resources)localObject);
    int j = wja.dp2px(10.0F, (Resources)localObject);
    if (Build.VERSION.SDK_INT >= 9) {
      ((HorizontalScrollView)paramLinearLayout.findViewById(2131382283)).setOverScrollMode(2);
    }
    localObject = (GridView)paramLinearLayout.findViewById(2131382274);
    ((GridView)localObject).setClickable(true);
    ((GridView)localObject).setColumnWidth(i);
    ((GridView)localObject).setStretchMode(0);
    ((GridView)localObject).setHorizontalSpacing(j);
    int k = this.jt.size();
    ((GridView)localObject).setLayoutParams(new LinearLayout.LayoutParams((i + j) * k - j, -2));
    ((GridView)localObject).setNumColumns(k);
    ((GridView)localObject).setOnItemClickListener(this.d);
    if (Build.VERSION.SDK_INT >= 9) {
      ((GridView)localObject).setOverScrollMode(2);
    }
    ((GridView)localObject).setAdapter(new jvq.a());
    paramLinearLayout.setClickable(false);
    paramLinearLayout.setOnClickListener(null);
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public jzs.a a(int paramInt)
    {
      return (jzs.a)jvq.this.jt.get(paramInt);
    }
    
    public int getCount()
    {
      return jvq.this.jt.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1 = jvq.this.mContext.getResources();
      int i = wja.dp2px(200.0F, (Resources)localObject1);
      int j = wja.dp2px(140.0F, (Resources)localObject1);
      int k = wja.dp2px(12.0F, (Resources)localObject1);
      Object localObject2;
      if (paramView == null)
      {
        paramView = new jvq.a.a();
        localObject1 = new BubbleViewLayout(jvq.this.mContext);
        ((BubbleViewLayout)localObject1).setRadius(6.0F);
        ((BubbleViewLayout)localObject1).TE(false);
        ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(j, i));
        localObject2 = new URLImageView(jvq.this.mContext);
        ((URLImageView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ((URLImageView)localObject2).setImageDrawable(new ColorDrawable(Color.parseColor("#33000000")));
        ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((ViewGroup)localObject1).addView((View)localObject2);
        paramView.e = ((URLImageView)localObject2);
        localObject2 = new TextView(jvq.this.mContext);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.addRule(14, -1);
        localLayoutParams.setMargins(k, 0, k, k);
        ((TextView)localObject2).setLayoutParams(localLayoutParams);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setTextSize(2, 16.0F);
        ((TextView)localObject2).setMaxLines(2);
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        ((ViewGroup)localObject1).addView((View)localObject2);
        paramView.text = ((TextView)localObject2);
        ((View)localObject1).setTag(paramView);
      }
      for (;;)
      {
        localObject2 = a(paramInt);
        paramView.e.setBackgroundDrawable(URLDrawable.getDrawable(((jzs.a)localObject2).pic_url, null, null, true));
        paramView.text.setText(((jzs.a)localObject2).title);
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (jvq.a.a)paramView.getTag();
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
    
    class a
    {
      URLImageView e;
      TextView text;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvq
 * JD-Core Version:    0.7.0.1
 */