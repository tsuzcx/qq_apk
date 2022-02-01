import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class wxw
{
  private wxw.b jdField_a_of_type_Wxw$b = new wxx(this);
  private wxw.c jdField_a_of_type_Wxw$c;
  public String aUw;
  public String aUx;
  public Context mContext;
  private String mMemberUin;
  private LinearLayout rootView;
  
  public wxw(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mMemberUin = paramString;
    this.rootView = new LinearLayout(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    this.rootView.setOrientation(1);
    this.rootView.setLayoutParams(paramContext);
    paramContext = aejx.a();
    this.aUw = paramContext.aUw;
    this.aUx = paramContext.aUx;
  }
  
  private int a(String paramString, float paramFloat, int paramInt)
  {
    int j = 0;
    Paint localPaint;
    if (!TextUtils.isEmpty(paramString))
    {
      localPaint = new Paint();
      localPaint.setTextSize(TypedValue.applyDimension(2, paramFloat, this.mContext.getResources().getDisplayMetrics()));
    }
    for (int i = (int)localPaint.measureText(paramString, 0, paramString.length());; i = 0)
    {
      paramString = (WindowManager)this.mContext.getSystemService("window");
      if (paramString != null) {
        j = paramString.getDefaultDisplay().getWidth();
      }
      return j - paramInt - i;
    }
  }
  
  public static void bk(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("intimate_relationship", 2, "jumph5Url strUrl Empty");
      return;
    }
    if ((paramString.toLowerCase().startsWith("http://")) || (paramString.toLowerCase().startsWith("https://")))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("selfSet_leftViewText", acfp.m(2131708115));
      paramContext.startActivity(localIntent);
      return;
    }
    QLog.e("intimate_relationship", 2, "jumph5Url strUrl unRecognized " + paramString);
  }
  
  public void a(wxw.c paramc)
  {
    this.jdField_a_of_type_Wxw$c = paramc;
  }
  
  public void clear()
  {
    if (this.rootView != null) {
      this.rootView.removeAllViews();
    }
    this.rootView = null;
    this.jdField_a_of_type_Wxw$b = null;
    this.mContext = null;
  }
  
  public void f(Context paramContext, ArrayList<IntimateInfo.MemoryDayInfo> paramArrayList)
  {
    int i = 0;
    if (this.rootView != null)
    {
      this.rootView.removeAllViews();
      ArrayList localArrayList = new ArrayList();
      Object localObject;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          IntimateInfo.MemoryDayInfo localMemoryDayInfo = (IntimateInfo.MemoryDayInfo)paramArrayList.next();
          if ((localMemoryDayInfo != null) && (localMemoryDayInfo.date != 0L))
          {
            Date localDate = new Date(localMemoryDayInfo.date);
            if ((((Date)localObject).getDay() == localDate.getDay()) && (((Date)localObject).getMonth() == localDate.getMonth()) && (((Date)localObject).getYear() == localDate.getYear())) {
              localArrayList.add(localMemoryDayInfo);
            }
          }
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        this.rootView.setVisibility(0);
      }
      while (i < localArrayList.size())
      {
        paramArrayList = (IntimateInfo.MemoryDayInfo)localArrayList.get(i);
        localObject = new wxw.a(paramContext);
        if (localObject != null)
        {
          ((wxw.a)localObject).b(paramArrayList);
          ((wxw.a)localObject).a(this.jdField_a_of_type_Wxw$b);
          if (((wxw.a)localObject).getItemView() != null) {
            this.rootView.addView(((wxw.a)localObject).getItemView());
          }
        }
        i += 1;
        continue;
        this.rootView.setVisibility(8);
      }
    }
  }
  
  public LinearLayout k()
  {
    return this.rootView;
  }
  
  public class a
  {
    private IntimateInfo.MemoryDayInfo a;
    private wxw.b jdField_b_of_type_Wxw$b;
    private View itemView;
    
    public a(Context paramContext)
    {
      this.itemView = LayoutInflater.from(paramContext).inflate(2131559447, null);
    }
    
    public void a(wxw.b paramb)
    {
      this.jdField_b_of_type_Wxw$b = paramb;
    }
    
    public void b(IntimateInfo.MemoryDayInfo paramMemoryDayInfo)
    {
      if (paramMemoryDayInfo != null)
      {
        this.a = paramMemoryDayInfo;
        if (this.itemView != null) {}
      }
      else
      {
        return;
      }
      this.itemView.setTag(paramMemoryDayInfo);
      URLThemeImageView localURLThemeImageView = (URLThemeImageView)this.itemView.findViewById(2131368698);
      TextView localTextView2 = (TextView)this.itemView.findViewById(2131382306);
      TextView localTextView1 = (TextView)this.itemView.findViewById(2131370508);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.itemView.findViewById(2131371246);
      Object localObject2 = (ImageView)this.itemView.findViewById(2131363230);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 686;
      localURLDrawableOptions.mRequestHeight = 124;
      localURLDrawableOptions.mRetryCount = 3;
      localURLDrawableOptions.mPlayGifImage = true;
      Object localObject1 = wxw.this.aUw;
      if (localURLThemeImageView != null)
      {
        if (localURLThemeImageView.a != null) {
          localURLThemeImageView.a.setMaskShape(auvj.euM);
        }
        if (paramMemoryDayInfo.iconUrl != null) {
          localURLThemeImageView.setBackgroundURL(paramMemoryDayInfo.iconUrl);
        }
      }
      if ((localRelativeLayout != null) && (ThemeUtil.isNowThemeIsNight(null, false, null))) {
        localObject1 = wxw.this.aUx;
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions));
        }
        for (;;)
        {
          if ((localTextView2 != null) && (paramMemoryDayInfo.wording != null))
          {
            localTextView2.setText(paramMemoryDayInfo.wording);
            localObject2 = "";
            localObject1 = localObject2;
            if (localTextView1 != null)
            {
              localObject1 = localObject2;
              if (paramMemoryDayInfo.linkWording != null) {
                localObject1 = paramMemoryDayInfo.linkWording;
              }
            }
            int i = wja.dp2px(95.0F, wxw.this.mContext.getResources());
            i = wxw.a(wxw.this, (String)localObject1, 14.0F, i + 80);
            if (i > 200) {
              localTextView2.setMaxWidth(i);
            }
          }
          else
          {
            if ((localTextView1 == null) || (paramMemoryDayInfo.linkWording == null)) {
              break;
            }
            localTextView1.setText(paramMemoryDayInfo.linkWording);
            if (TextUtils.isEmpty(paramMemoryDayInfo.linkColor)) {}
          }
          try
          {
            localTextView1.setTextColor(Color.parseColor(paramMemoryDayInfo.linkColor));
            localTextView1.setOnClickListener(new wxy(this));
            return;
            QLog.e("intimate_relationship", 2, " url is empty");
            continue;
            localTextView2.setMaxWidth(200);
          }
          catch (IllegalArgumentException paramMemoryDayInfo)
          {
            for (;;)
            {
              QLog.e("intimate_relationship", 2, " color parse err");
            }
          }
        }
      }
    }
    
    public View getItemView()
    {
      return this.itemView;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, IntimateInfo.MemoryDayInfo paramMemoryDayInfo);
  }
  
  public static abstract interface c
  {
    public abstract void a(IntimateInfo.MemoryDayInfo paramMemoryDayInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxw
 * JD-Core Version:    0.7.0.1
 */