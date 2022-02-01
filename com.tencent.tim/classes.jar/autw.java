import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianNegativeWindow.3;
import com.tencent.widget.NegativeChildrenLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class autw
  extends PopupWindow
{
  View Cb;
  ArrayList<DislikeInfo> Eu = new ArrayList();
  ArrayList<DislikeInfo> Ev = new ArrayList();
  ArrayList<DislikeInfo> Ew = new ArrayList();
  ArrayList<DislikeInfo> Ex = new ArrayList();
  ArrayList<DislikeInfo> Ey = new ArrayList();
  ArrayList<View> Ez = new ArrayList();
  ImageView Hl;
  ImageView Hm;
  View Lk;
  View Ll;
  View Lm;
  View Ln;
  public final String TAG = "KandianNegativeWindow";
  autw.a jdField_a_of_type_Autw$a;
  autw.b jdField_a_of_type_Autw$b = new autz(this);
  NegativeChildrenLayout jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout;
  protected int aLh;
  public final String cIW = acfp.m(2131707559);
  View.OnClickListener clickListener = new auty(this);
  public final int etB = 1;
  public final int etC = 2;
  public final int etD = 3;
  public final int etE = 5;
  public final int etF = 8;
  public final int etG = 9;
  public final int etH = 3;
  public int etI = -1;
  int etJ;
  public int etK;
  int etL = 0;
  protected int etM;
  protected int mChannelID;
  View mContentView;
  Context mContext;
  String mRowKey = "";
  public int mScreenHeight;
  public int mScreenWidth;
  int mType;
  String mTypeName = "";
  public int mWindowWidth;
  LinearLayout mg;
  LinearLayout mh;
  Map<Long, String> pO = new HashMap(6);
  
  public autw(@NonNull Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131560434, null);
    setContentView(this.mContentView);
    setHeight(-2);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    try
    {
      initUI(this.mContentView);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void U(View paramView, boolean paramBoolean)
  {
    Object localObject = this.mg;
    paramView = this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout;
    float f2;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout;
      paramView = this.mg;
      f2 = -1.0F;
    }
    for (float f1 = 1.0F;; f1 = -1.0F)
    {
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(1, f1, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation1.setDuration(300L);
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(1, 0.0F, 1, f2, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      ((View)localObject).startAnimation(localTranslateAnimation1);
      paramView.startAnimation(localTranslateAnimation2);
      return;
      f2 = 1.0F;
    }
  }
  
  private void V(View paramView, boolean paramBoolean)
  {
    int i = 0;
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if (arrayOfInt[0] < this.mScreenWidth * 2 / 3) {}
    for (;;)
    {
      if (paramBoolean) {
        if (i != 0) {
          i = 2131755044;
        }
      }
      for (;;)
      {
        setAnimationStyle(i);
        return;
        i = 2131755045;
        continue;
        if (i != 0) {
          i = 2131755041;
        } else {
          i = 2131755042;
        }
      }
      i = 1;
    }
  }
  
  private void W(View paramView, boolean paramBoolean)
  {
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    int i = localObject[0];
    int j = paramView.getWidth() / 2;
    int k = this.etJ;
    localObject = (LinearLayout.LayoutParams)this.Hm.getLayoutParams();
    if (!paramBoolean) {
      localObject = (LinearLayout.LayoutParams)this.Hl.getLayoutParams();
    }
    ((LinearLayout.LayoutParams)localObject).leftMargin = (i + j - k - paramView.getWidth() / 5);
    if (paramBoolean)
    {
      this.Hm.setVisibility(0);
      this.Hl.setVisibility(8);
      this.Hm.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      Wg(paramBoolean);
      return;
      this.Hl.setVisibility(0);
      this.Hm.setVisibility(8);
      this.Hl.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void Wg(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, this.mh.getId());
    if (paramBoolean) {
      localLayoutParams.addRule(12);
    }
    for (;;)
    {
      this.mh.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(10);
    }
  }
  
  private boolean a(View paramView, int[] paramArrayOfInt)
  {
    int i = OP();
    paramView.getLocationOnScreen(paramArrayOfInt);
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    boolean bool;
    if (paramArrayOfInt[1] + i + paramView.getHeight() <= this.mScreenHeight)
    {
      paramArrayOfInt[1] = (paramArrayOfInt[1] + paramView.getHeight() / 2 + paramView.getHeight() / 8);
      setAnimationStyle(2131755042);
      bool = false;
      V(paramView, bool);
      W(paramView, bool);
      paramArrayOfInt[0] = ((this.mScreenWidth - this.mWindowWidth) / 2);
      if ((this.etI > 0) && (this.mScreenHeight > 0)) {
        break label173;
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new KandianNegativeWindow.3(this, localStringBuilder, j, k, true));
      return true;
      setAnimationStyle(2131755045);
      paramArrayOfInt[1] = (paramArrayOfInt[1] + paramView.getHeight() / 2 - i - paramView.getHeight() / 8);
      bool = true;
      break;
      label173:
      if ((paramArrayOfInt[0] <= 0) || (paramArrayOfInt[1] <= 0) || (this.etK > 0)) {}
    }
  }
  
  private void exa()
  {
    exb();
    int i = this.Ez.size();
    if (i > 0)
    {
      if (i <= 1) {
        ((View)this.Ez.get(0)).setBackgroundResource(2130843774);
      }
    }
    else {
      return;
    }
    ((View)this.Ez.get(0)).setBackgroundResource(2130843776);
    ((View)this.Ez.get(i - 1)).setBackgroundResource(2130843775);
  }
  
  private void g(Object paramObject, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("folder_status", kxm.aMw);
      localJSONObject.put("kandian_mode", kxm.nR());
      localJSONObject.put("feeds_type", "" + this.aLh);
      localJSONObject.put("channel_id", this.mChannelID + "");
      if (TextUtils.isEmpty(this.mRowKey)) {
        this.mRowKey = "";
      }
      localJSONObject.put("rowkey", this.mRowKey);
      paramObject = (DislikeInfo)paramObject;
      if (paramObject != null)
      {
        localJSONObject.put("tag_id", paramObject.vf + "");
        localJSONObject.put("tag_name", paramObject.agQ);
        if (paramBoolean) {
          this.mTypeName = paramObject.agQ;
        }
      }
    }
    catch (Exception paramObject)
    {
      label196:
      break label196;
    }
    kbp.a(null, "", "0X8009990", "0X8009990", 0, 0, String.valueOf(this.mType), "", this.mTypeName, localJSONObject.toString(), false);
  }
  
  private String z(ArrayList<DislikeInfo> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayList.size()) || (i >= 3)) {
        return localStringBuilder.toString();
      }
      if (!TextUtils.isEmpty(((DislikeInfo)paramArrayList.get(i)).agQ))
      {
        if (i != 0) {
          localStringBuilder.append("、");
        }
        localStringBuilder.append(((DislikeInfo)paramArrayList.get(i)).agQ);
      }
      i += 1;
    }
  }
  
  protected int OO()
  {
    int j = this.Eu.size();
    int i = j;
    if (this.Ev.size() > j) {
      i = this.Ev.size();
    }
    j = i;
    if (this.Ew.size() > i) {
      j = this.Ew.size();
    }
    i = j;
    if (this.Ex.size() > j) {
      i = this.Ex.size();
    }
    j = i;
    if (i > 6) {
      j = 6;
    }
    return j;
  }
  
  protected int OP()
  {
    if (this.etI <= 0)
    {
      iU(this.Hm);
      this.etI = this.Hm.getMeasuredHeight();
    }
    int i = (OO() + 1) * this.etK + this.etI;
    iU(this.Lk);
    int j = this.Lk.getMeasuredHeight() * this.etL + this.etI;
    if (i > j) {
      return i;
    }
    return j;
  }
  
  protected void Wh(boolean paramBoolean)
  {
    int j = 8;
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      this.mg.setVisibility(j);
      this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setVisibility(i);
      if (paramBoolean)
      {
        U(this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout, paramBoolean);
        return;
      }
      U(this.mg, paramBoolean);
      return;
      j = 0;
      i = 8;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<DislikeInfo> paramArrayList, String paramString)
  {
    clearData();
    this.etM = paramInt1;
    this.mChannelID = paramInt2;
    this.aLh = paramInt3;
    this.mRowKey = paramString;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
        if (localDislikeInfo != null)
        {
          switch (localDislikeInfo.type)
          {
          }
          for (;;)
          {
            QLog.e("KandianNegativeWindow", 1, "dislikeInfo," + localDislikeInfo.toString());
            break;
            this.Eu.add(localDislikeInfo);
            continue;
            if (TextUtils.isEmpty(localDislikeInfo.agQ))
            {
              String str = (String)this.pO.get(Long.valueOf(localDislikeInfo.vf));
              paramString = str;
              if (str == null) {
                paramString = "";
              }
              localDislikeInfo.agQ = paramString;
            }
            this.Ev.add(localDislikeInfo);
            continue;
            this.Ew.add(localDislikeInfo);
          }
        }
      }
    }
    for (paramInt1 = paramArrayList.size();; paramInt1 = 0)
    {
      paramArrayList = new DislikeInfo();
      paramArrayList.agQ = this.cIW;
      paramArrayList.type = 9;
      paramArrayList.puin = "";
      this.Ex.add(paramArrayList);
      paramArrayList = new DislikeInfo();
      paramArrayList.type = 8;
      paramArrayList.puin = "";
      this.Ey.add(paramArrayList);
      a(this.Eu, this.Lk, 2130842509, acfp.m(2131707565), true);
      a(this.Ev, this.Cb, 2130842513, acfp.m(2131707575), true);
      a(this.Ew, this.Ll, 2130842502, z(this.Ew), false);
      a(this.Ex, this.Lm, 2130842506, acfp.m(2131707571), false);
      ewZ();
      QLog.e("KandianNegativeWindow", 1, "setData,size:" + paramInt1);
      return;
    }
  }
  
  public void a(View paramView, autw.a parama)
  {
    if (isShowing()) {
      dismiss();
    }
    this.jdField_a_of_type_Autw$a = parama;
    parama = new int[2];
    try
    {
      bool = a(paramView, parama);
      if (bool)
      {
        showAtLocation(paramView, 51, parama[0], parama[1]);
        i(0.8F);
        b(this);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  protected void a(ArrayList<DislikeInfo> paramArrayList, View paramView, int paramInt, String paramString, boolean paramBoolean)
  {
    int i = 8;
    int j = i;
    TextView localTextView;
    ImageView localImageView;
    if (!paramArrayList.isEmpty())
    {
      j = i;
      if (!TextUtils.isEmpty(paramString))
      {
        ((TextView)paramView.findViewById(2131369532)).setText(paramString);
        localTextView = (TextView)paramView.findViewById(2131369528);
        localImageView = (ImageView)paramView.findViewById(2131369517);
        ((ImageView)paramView.findViewById(2131369459)).setImageResource(paramInt);
        paramString = "";
        if (!paramBoolean) {
          break label150;
        }
        paramArrayList = z(paramArrayList);
        paramView.setTag(null);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramArrayList)) {
        i = 0;
      }
      localImageView.setVisibility(i);
      localTextView.setText(paramArrayList);
      localTextView.setVisibility(i);
      this.etL += 1;
      j = 0;
      paramView.setVisibility(j);
      return;
      label150:
      paramView.setTag(paramArrayList.get(0));
      paramArrayList = paramString;
    }
  }
  
  public void a(lis paramlis, ArrayList<DislikeInfo> paramArrayList)
  {
    int j = 0;
    String str = null;
    if (paramlis != null) {}
    for (;;)
    {
      try
      {
        i = paramlis.mPosition;
        j = paramlis.mChannelID;
        paramlis = paramlis.a();
        int k = kxm.a(paramlis);
        str = "";
        if (paramlis != null) {
          str = paramlis.innerUniqueID;
        }
        a(i, j, k, paramArrayList, str);
        return;
      }
      catch (Exception paramlis)
      {
        return;
      }
      int i = 0;
      paramlis = str;
    }
  }
  
  public void b(PopupWindow paramPopupWindow)
  {
    try
    {
      View localView;
      if (Build.VERSION.SDK_INT >= 23)
      {
        localView = (View)paramPopupWindow.getContentView().getParent();
        if (paramPopupWindow.getBackground() == null) {
          break label95;
        }
        localView = (View)localView.getParent();
      }
      for (;;)
      {
        paramPopupWindow = (WindowManager)paramPopupWindow.getContentView().getContext().getSystemService("window");
        WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localView.getLayoutParams();
        localLayoutParams.flags |= 0x2;
        localLayoutParams.dimAmount = 0.2F;
        paramPopupWindow.updateViewLayout(localView, localLayoutParams);
        return;
        localView = paramPopupWindow.getContentView();
        break;
      }
    }
    catch (Exception paramPopupWindow) {}
  }
  
  protected void clearData()
  {
    this.Eu.clear();
    this.Ev.clear();
    this.Ew.clear();
    this.Ex.clear();
    this.Ez.clear();
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setVisibility(8);
    this.mg.setVisibility(0);
    this.etL = 0;
  }
  
  protected void ewZ()
  {
    setHeight(OP());
    exa();
  }
  
  protected void exb()
  {
    this.Ez.clear();
    y(this.Eu.size(), this.Lk);
    y(this.Ev.size(), this.Cb);
    y(this.Ew.size(), this.Ll);
    y(this.Ex.size(), this.Lm);
  }
  
  public void i(float paramFloat)
  {
    if ((this.mContext instanceof Activity)) {}
  }
  
  protected void iU(View paramView)
  {
    paramView.measure(0, 0);
  }
  
  protected void iV(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Autw$a == null);
      paramView = paramView.getTag();
    } while (!(paramView instanceof DislikeInfo));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add((DislikeInfo)paramView);
    this.jdField_a_of_type_Autw$a.a(null, this.etM, localArrayList, null);
  }
  
  protected void initUI(View paramView)
  {
    this.Lk = paramView.findViewById(2131372261);
    this.Cb = paramView.findViewById(2131372257);
    this.Ll = paramView.findViewById(2131372263);
    this.Lm = paramView.findViewById(2131372260);
    this.Ln = paramView.findViewById(2131372259);
    this.Lk.setOnClickListener(this.clickListener);
    this.Cb.setOnClickListener(this.clickListener);
    this.Ll.setOnClickListener(this.clickListener);
    this.Lm.setOnClickListener(this.clickListener);
    this.Ln.setOnClickListener(this.clickListener);
    this.Hl = ((ImageView)paramView.findViewById(2131372264));
    this.Hm = ((ImageView)paramView.findViewById(2131372265));
    this.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout = ((NegativeChildrenLayout)paramView.findViewById(2131364599));
    this.mg = ((LinearLayout)paramView.findViewById(2131371094));
    ((ImageView)paramView.findViewById(2131367119).findViewById(2131370351)).setOnClickListener(this.clickListener);
    this.mScreenWidth = ((int)aqgz.hK());
    this.mScreenHeight = ((int)aqgz.hL());
    this.etJ = ((int)this.mContext.getResources().getDimension(2131299225));
    this.mWindowWidth = (this.mScreenWidth - this.etJ * 2);
    setWidth(this.mWindowWidth);
    this.mh = ((LinearLayout)paramView.findViewById(2131365360));
    this.pO.put(Long.valueOf(1L), acfp.m(2131707572));
    this.pO.put(Long.valueOf(2L), acfp.m(2131707570));
    this.pO.put(Long.valueOf(3L), acfp.m(2131707561));
    this.pO.put(Long.valueOf(4L), acfp.m(2131707562));
    this.pO.put(Long.valueOf(5L), acfp.m(2131707567));
    this.pO.put(Long.valueOf(6L), acfp.m(2131707566));
    this.etK = ((int)this.mContext.getResources().getDimension(2131299201));
    this.Lm.findViewById(2131378043).setVisibility(4);
    setBackgroundDrawable(new ColorDrawable());
    setOnDismissListener(new autx(this));
    this.mContentView.setOnClickListener(this.clickListener);
  }
  
  protected void showToast()
  {
    dismiss();
  }
  
  protected void y(int paramInt, View paramView)
  {
    if (paramInt > 0) {
      this.Ez.add(paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject);
  }
  
  public static abstract interface b
  {
    public abstract void iW(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     autw
 * JD-Core Version:    0.7.0.1
 */