import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector.1;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class meu
{
  public static int aQL;
  public static int aQM;
  public static int aQN;
  public static int aQO = 1;
  public static int aQP = 2;
  public static int aQQ = 3;
  public static int aQR = 4;
  public static double aX = 0.5D;
  public static String ago;
  public static String agp;
  private static volatile meu b;
  public meu.d a = new meu.d();
  private int aQS;
  public int aQT;
  public int aQU;
  private String agq;
  public boolean amh;
  private boolean ami;
  public int[] dj = new int[2];
  private int[] dk;
  private HashMap<String, Integer> eb = new HashMap();
  public HashMap<String, Long> ec = new HashMap();
  public long enterTime;
  public List<meu.a> iE = new ArrayList();
  public List<meu.c> iF = new ArrayList();
  private ArrayList<Integer> kO = new ArrayList();
  private long lastClickTime;
  public long tT;
  public long uQ;
  private long uR;
  private long uS;
  private long uT = -1L;
  private WeakReference<AbsListView> y;
  
  static
  {
    aQL = 5;
    aQM = 20;
    aQN = 10;
    ago = "sp_mix_feature_click_info";
    agp = "sp_mix_feature_scroll_info";
  }
  
  private meu()
  {
    if (Aladdin.getConfig(234).getIntegerFromString("fbs_enable", 0) == 1) {}
    for (;;)
    {
      this.ami = bool;
      if (this.ami) {
        break;
      }
      return;
      bool = false;
    }
    try
    {
      String str = (String)awit.f(ago, "");
      Object localObject2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = str.split("_");
        int j = localObject1.length;
        while (i < j)
        {
          localObject2 = localObject1[i];
          this.kO.add(Integer.valueOf((String)localObject2));
          i += 1;
        }
      }
      Object localObject1 = (String)awit.f(agp, "");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).split("_").length == 4))
      {
        localObject2 = ((String)localObject1).split("_");
        this.dk = new int[4];
        this.dk[0] = Integer.valueOf(localObject2[0]).intValue();
        this.dk[1] = Integer.valueOf(localObject2[1]).intValue();
        this.dk[2] = Integer.valueOf(localObject2[2]).intValue();
        this.dk[3] = Integer.valueOf(localObject2[3]).intValue();
      }
      QLog.d("UserActionCollector", 1, "clickStr : " + str + ", scrollStr : " + (String)localObject1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      awit.H(ago, "");
      awit.H(agp, "");
    }
  }
  
  private Object a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || (paramInt < 0) || (paramAbsListView.getAdapter() == null)) {}
    do
    {
      return null;
      paramAbsListView = paramAbsListView.getAdapter();
    } while (paramInt >= paramAbsListView.getCount());
    try
    {
      paramAbsListView = paramAbsListView.getItem(paramInt);
      return paramAbsListView;
    }
    catch (Exception paramAbsListView)
    {
      paramAbsListView.printStackTrace();
    }
    return null;
  }
  
  public static meu a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new meu();
      }
      return b;
    }
    finally {}
  }
  
  private void a(AbsListView paramAbsListView, boolean paramBoolean)
  {
    if (paramAbsListView == null) {
      return;
    }
    int k = paramAbsListView.getFirstVisiblePosition();
    if (this.uT != -1L) {}
    Object localObject1;
    View localView;
    for (long l1 = System.currentTimeMillis() - this.uT;; l1 = System.currentTimeMillis() - this.enterTime)
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramAbsListView.getChildCount()) {
          break label527;
        }
        localObject1 = a(paramAbsListView, k + i);
        localView = paramAbsListView.getChildAt(i);
        if (((localObject1 instanceof BaseArticleInfo)) && (localView != null)) {
          break;
        }
        i += 1;
      }
    }
    int m = b(localView, paramAbsListView.getHeight());
    Object localObject2 = (BaseArticleInfo)localObject1;
    String str = n((BaseArticleInfo)localObject2);
    long l3;
    if (this.eb.containsKey(str))
    {
      localObject1 = (meu.a)this.iE.get(((Integer)this.eb.get(str)).intValue());
      l3 = ((meu.a)localObject1).uV;
      if (m <= 0) {
        break label521;
      }
    }
    label521:
    for (long l2 = l1;; l2 = 0L)
    {
      ((meu.a)localObject1).uV = (l2 + l3);
      localObject2 = b(localView);
      if ((localObject2 != null) && (localObject2[1] - localObject2[0] >= localView.getHeight() * aX)) {
        ((meu.a)localObject1).uW += l1;
      }
      ((meu.a)localObject1).isClick = this.ec.containsKey(str);
      if (!paramBoolean) {
        break;
      }
      ((meu.a)localObject1).amk = true;
      break;
      localObject1 = new meu.a();
      ((meu.a)localObject1).feedID = str;
      ((meu.a)localObject1).style = kxm.a((BaseArticleInfo)localObject2);
      int j;
      label305:
      boolean bool;
      if (TextUtils.isEmpty(((BaseArticleInfo)localObject2).mTitle))
      {
        j = 0;
        ((meu.a)localObject1).aQW = j;
        if (this.uT != -1L) {
          break label504;
        }
        bool = true;
        label326:
        ((meu.a)localObject1).amj = bool;
        ((meu.a)localObject1).viewHeight = localView.getHeight();
        ((meu.a)localObject1).agr = ((BaseArticleInfo)localObject2).mRecommentdReason;
        j = this.aQS;
        this.aQS = (j + 1);
        ((meu.a)localObject1).aQX = j;
        localObject2 = kxt.a().a();
        if ((localObject2 == null) || (localObject2.length != 4)) {
          break label510;
        }
      }
      label504:
      label510:
      for (((meu.a)localObject1).ags = (localObject2[0] + "_" + localObject2[1] + "_" + localObject2[2] + "_" + localObject2[3]);; ((meu.a)localObject1).ags = "NULL")
      {
        this.iE.add(localObject1);
        this.eb.put(str, Integer.valueOf(this.iE.size() - 1));
        break;
        j = ((BaseArticleInfo)localObject2).mTitle.length();
        break label305;
        bool = false;
        break label326;
      }
    }
    label527:
    this.uT = System.currentTimeMillis();
  }
  
  private void aOT()
  {
    int i = 0;
    String str;
    if (this.dk != null)
    {
      str = this.dk[0] + "_" + this.dk[1] + "_" + this.dk[2] + "_" + this.dk[3];
      awit.H(agp, str);
    }
    if (this.kO.size() > 0)
    {
      if (this.kO.size() > aQM) {
        i = this.kO.size() - aQM;
      }
      str = TextUtils.join("_", this.kO.subList(i, this.kO.size()));
      awit.H(ago, str);
    }
  }
  
  private int b(View paramView, int paramInt)
  {
    int i = paramView.getHeight();
    double d = paramView.getTop();
    i = (int)(i * aX + d);
    if (i <= paramInt)
    {
      paramInt = i;
      if (i > 0) {}
    }
    else
    {
      paramInt = -1;
    }
    return paramInt;
  }
  
  private int[] b(View paramView)
  {
    int[] arrayOfInt = v();
    int i;
    if (paramView.getTop() < 0)
    {
      i = 0;
      if (paramView.getBottom() <= this.aQU) {
        break label57;
      }
    }
    label57:
    for (int j = this.aQU;; j = paramView.getBottom())
    {
      if ((j > arrayOfInt[0]) && (arrayOfInt[1] > i)) {
        break label65;
      }
      return null;
      i = paramView.getTop();
      break;
    }
    label65:
    return new int[] { Math.max(i, arrayOfInt[0]), Math.min(j, arrayOfInt[1]) };
  }
  
  private String n(BaseArticleInfo paramBaseArticleInfo)
  {
    String str2 = paramBaseArticleInfo.innerUniqueID;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "AD_" + paramBaseArticleInfo.mTitle;
    }
    return str1;
  }
  
  public void aOQ()
  {
    if ((this.enterTime == 0L) || (this.uS == 0L) || (!this.ami)) {
      return;
    }
    long l = System.currentTimeMillis() - this.uS;
    this.uR += l;
    if ((this.lastClickTime != 0L) && (!TextUtils.isEmpty(this.agq)) && (this.eb.containsKey(this.agq)))
    {
      int i = ((Integer)this.eb.get(this.agq)).intValue();
      meu.a locala = (meu.a)this.iE.get(i);
      locala.uU = (l + locala.uU);
      this.lastClickTime = 0L;
      this.agq = null;
    }
    this.uS = 0L;
  }
  
  public void aOR()
  {
    if ((this.enterTime == 0L) || (!this.ami)) {
      return;
    }
    this.uS = System.currentTimeMillis();
    if (this.y != null) {}
    for (AbsListView localAbsListView = (AbsListView)this.y.get();; localAbsListView = null)
    {
      a(localAbsListView, false);
      return;
    }
  }
  
  public void aOS()
  {
    if ((this.enterTime == 0L) || (this.y == null) || (!this.ami)) {
      return;
    }
    QLog.d("UserActionCollector", 1, "exitBusiness !");
    kxt.a().unRegister();
    this.tT = System.currentTimeMillis();
    this.uR = (this.tT - this.enterTime - this.uR);
    a((AbsListView)this.y.get(), true);
    new ljc(null, null, null, lun.a(), null).a(this, BaseApplication.getContext());
    aOT();
    this.y = null;
    b = null;
  }
  
  public void aOU()
  {
    float f = 0.0F;
    this.dj = new int[2];
    int i;
    int j;
    int k;
    int[] arrayOfInt;
    if (this.kO.size() < aQL)
    {
      if (this.dk == null)
      {
        this.dj[0] = 0;
        this.dj[1] = ((int)(this.aQU * 2 / 3.0F));
        i = 0;
        QLog.d("UserActionCollector", 1, "listViewHeight : " + this.aQU + ", az[0] : " + this.dj[0] + ", az[1] : " + this.dj[1] + ", rule : " + i);
        return;
      }
      i = (int)(Math.min(this.dk[1], this.dk[3]) - this.aQU / 8.0F);
      j = (int)(Math.max(this.dk[1], this.dk[3]) + this.aQU / 8.0F);
      k = (i + j) / 2;
      if (j - i > this.aQU / 2.0F)
      {
        arrayOfInt = this.dj;
        if (k - this.aQU / 4.0F < 0.0F)
        {
          label228:
          arrayOfInt[0] = ((int)f);
          arrayOfInt = this.dj;
          if (k + this.aQU / 4.0F <= this.aQU) {
            break label296;
          }
          f = this.aQU;
          label268:
          arrayOfInt[1] = ((int)f);
        }
      }
      for (;;)
      {
        i = 1;
        break;
        f = k - this.aQU / 4.0F;
        break label228;
        label296:
        f = k + this.aQU / 4.0F;
        break label268;
        this.dj[0] = i;
        this.dj[1] = j;
      }
    }
    label348:
    int m;
    if (this.kO.size() > aQM)
    {
      k = aQM;
      arrayOfInt = new int[aQN];
      m = (int)(this.aQU * 1.0F / aQN + 0.5F);
      if (m > 0) {
        break label616;
      }
      m = 1;
    }
    label398:
    label605:
    label616:
    for (;;)
    {
      int i3 = this.kO.size();
      int n = 0;
      j = 0;
      i = 0;
      int i1;
      if (n < k)
      {
        i1 = ((Integer)this.kO.get(i3 - 1 - n)).intValue() / m % aQN;
        int i2 = arrayOfInt[i1] + 1;
        arrayOfInt[i1] = i2;
        if (i2 <= i) {
          break label605;
        }
        j = i2;
        i = i1;
      }
      for (;;)
      {
        i1 = n + 1;
        n = j;
        j = i;
        i = n;
        n = i1;
        break label398;
        k = this.kO.size();
        break label348;
        i = (j + 1) * m + m / 2;
        this.dj[0] = (i - this.aQU / 4);
        if (this.dj[0] < 0) {
          this.dj[0] = 0;
        }
        this.dj[1] = (this.aQU / 4 + i);
        if (this.dj[1] > this.aQU) {
          this.dj[1] = this.aQU;
        }
        QLog.d("UserActionCollector", 1, "calculate az, centerY : " + i);
        i = 2;
        break;
        i1 = i;
        i = j;
        j = i1;
      }
    }
  }
  
  public void b(View paramView, AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((this.enterTime == 0L) || (paramBaseArticleInfo == null) || (!this.ami)) {
      return;
    }
    this.amh = true;
    paramView = n(paramBaseArticleInfo);
    if (!this.ec.containsKey(paramView)) {
      this.ec.put(paramView, Long.valueOf(0L));
    }
    paramBaseArticleInfo = new float[2];
    paramBaseArticleInfo[0] = ((ReadInJoyXListView)paramAbsListView).ar[0];
    paramBaseArticleInfo[1] = (((ReadInJoyXListView)paramAbsListView).ar[1] - paramAbsListView.getPaddingTop());
    paramAbsListView = new meu.c();
    paramAbsListView.agu = ((int)paramBaseArticleInfo[0] + "_" + (int)paramBaseArticleInfo[1]);
    this.iF.add(paramAbsListView);
    if (paramBaseArticleInfo[1] > 0.0F) {
      this.kO.add(Integer.valueOf((int)paramBaseArticleInfo[1]));
    }
    this.agq = paramView;
    this.lastClickTime = System.currentTimeMillis();
  }
  
  public long cJ()
  {
    if (this.a.tQ == 0L) {
      return this.uR;
    }
    return this.a.tQ - this.enterTime;
  }
  
  public long cK()
  {
    if (this.a.tR == 0L) {
      return this.uR;
    }
    return this.tT - this.a.tR;
  }
  
  public long cL()
  {
    return this.uR;
  }
  
  public void cQ(int paramInt1, int paramInt2)
  {
    if (!this.ami) {
      return;
    }
    QLog.d("UserActionCollector", 1, "enterBusiness, from : " + paramInt1 + ", scene : " + paramInt2);
    this.enterTime = System.currentTimeMillis();
    this.aQT = paramInt1;
    this.uQ = paramInt2;
    kxt.a().register();
  }
  
  public void i(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || ((this.y != null) && (paramAbsListView == this.y.get())) || (!this.ami)) {
      return;
    }
    QLog.d("UserActionCollector", 1, "register listview : " + paramAbsListView);
    this.y = new WeakReference(paramAbsListView);
    this.aQU = ankt.aC(paramAbsListView.getContext());
    ((ReadInJoyXListView)paramAbsListView).c(this.a);
    paramAbsListView.post(new UserActionCollector.1(this, paramInt, paramAbsListView));
  }
  
  public int[] v()
  {
    if ((this.uT == 0L) || (this.dj == null)) {
      return new int[] { 0, (int)(this.aQU * 2 / 3.0F) };
    }
    return this.dj;
  }
  
  public class a
  {
    public String Wz;
    public int aQW;
    public int aQX;
    public String agr;
    public String ags;
    public boolean amj;
    public boolean amk;
    public String feedID;
    public boolean isClick;
    public int style;
    public long uU;
    public long uV;
    public long uW;
    public int viewHeight;
    
    public a() {}
    
    public String toString()
    {
      return "\nFeedExpInfo{feedID='" + this.feedID + '\'' + ", recReason='" + this.agr + '\'' + ", style=" + this.style + ", wordCnt=" + this.aQW + ", viewHeight=" + this.viewHeight + ", isFirstScreen=" + this.amj + ", isLastScreen=" + this.amk + ", expPosition=" + this.aQX + ", isClick=" + this.isClick + ", readDuration=" + this.uU + ", expDuration=" + this.uV + ", expInAZDuration=" + this.uW + ", gyroscopeData='" + this.ags + '\'' + ", articleID='" + this.Wz + '\'' + '}';
    }
  }
  
  public class b
  {
    public int aQY = -2019;
    public int aQZ = -2019;
    public int aRa = -2019;
    public int aRb = -2019;
    public double aY;
    public String feedID;
    public long uX;
    public long uY;
    public int viewHeight;
    
    public b() {}
    
    public String toString()
    {
      return "\nFeedScrollStateInfo{feedID='" + this.feedID + '\'' + ", viewHeight=" + this.viewHeight + ", starTopOffset=" + this.aQY + ", endTopOffset=" + this.aQZ + ", startBottomOffset=" + this.aRa + ", endBottomOffset=" + this.aRb + ", enterAZSpeed=" + this.aY + ", enterAZTime=" + this.uX + ", exitAZTime=" + this.uY + "}";
    }
  }
  
  public class c
  {
    public String agt;
    public String agu;
    public int direction;
    public float jA;
    public ArrayList<meu.b> kP;
    public long uZ;
    public long va;
    public long vb;
    
    public c() {}
    
    public String toString()
    {
      return "\nGestureEvent{direction=" + this.direction + ", deltaFromLastScroll=" + this.uZ + ", scrollDistance=" + this.va + ", scrollMills=" + this.vb + ", scrollSpeed=" + this.jA + ", scrollDownAndUpCoordinate='" + this.agt + '\'' + ", clickCoordinate='" + this.agu + '\'' + ", scrollStateInfos=" + this.kP + "}";
    }
  }
  
  public class d
    implements AbsListView.e
  {
    public boolean aml;
    public ArrayList<meu.b> kQ = new ArrayList();
    public HashMap<String, Integer> map = new HashMap();
    private int maxHeight;
    public long tQ;
    public long tR;
    public long tS;
    
    public d() {}
    
    private void a(boolean paramBoolean1, boolean paramBoolean2, AbsListView paramAbsListView)
    {
      int j = paramAbsListView.getChildCount();
      int k = paramAbsListView.getFirstVisiblePosition();
      int i = 0;
      if (i < j)
      {
        View localView = paramAbsListView.getChildAt(i);
        Object localObject1 = meu.a(meu.this, paramAbsListView, k + i);
        label110:
        Object localObject2;
        if ((localObject1 instanceof BaseArticleInfo))
        {
          localObject1 = (BaseArticleInfo)localObject1;
          String str = meu.a(meu.this, (BaseArticleInfo)localObject1);
          if (!this.map.containsKey(str)) {
            break label262;
          }
          localObject1 = (meu.b)this.kQ.get(((Integer)this.map.get(str)).intValue());
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            this.maxHeight += localView.getHeight();
            localObject2 = new meu.b(meu.this);
            ((meu.b)localObject2).feedID = str;
            ((meu.b)localObject2).viewHeight = localView.getHeight();
            this.kQ.add(localObject2);
            this.map.put(str, Integer.valueOf(this.kQ.size() - 1));
          }
          if (!paramBoolean1) {
            break label268;
          }
          ((meu.b)localObject2).aQY = localView.getTop();
          ((meu.b)localObject2).aRa = localView.getBottom();
          label219:
          localObject1 = meu.a(meu.this, localView);
          if ((localObject1 == null) || (((meu.b)localObject2).uX != 0L)) {
            break label295;
          }
          ((meu.b)localObject2).uX = System.currentTimeMillis();
        }
        for (;;)
        {
          i += 1;
          break;
          label262:
          localObject1 = null;
          break label110;
          label268:
          if (!paramBoolean2) {
            break label219;
          }
          ((meu.b)localObject2).aQZ = localView.getTop();
          ((meu.b)localObject2).aRb = localView.getBottom();
          break label219;
          label295:
          if (localObject1 != null)
          {
            ((meu.b)localObject2).uY = System.currentTimeMillis();
            localObject1 = meu.this.v();
            ((meu.b)localObject2).aY = ((localObject1[1] - localObject1[0]) * 1.0F / (float)(((meu.b)localObject2).uY - ((meu.b)localObject2).uX));
          }
        }
      }
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.aml) {
        a(false, false, paramAbsListView);
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramAbsListView == null) || (meu.this.enterTime == 0L)) {
        return;
      }
      meu.c localc;
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        a(false, true, paramAbsListView);
        float[] arrayOfFloat = ((ReadInJoyXListView)paramAbsListView).aq;
        paramAbsListView = ((ReadInJoyXListView)paramAbsListView).ar;
        meu.a(meu.this, new int[4]);
        meu.a(meu.this)[0] = ((int)arrayOfFloat[0]);
        meu.a(meu.this)[1] = ((int)arrayOfFloat[1]);
        meu.a(meu.this)[2] = ((int)paramAbsListView[0]);
        meu.a(meu.this)[3] = ((int)paramAbsListView[1]);
        localc = new meu.c(meu.this);
        if (paramAbsListView[1] - arrayOfFloat[1] > 0.0F)
        {
          paramInt = 2;
          localc.direction = paramInt;
          localc.va = (this.maxHeight - meu.this.aQU);
          localc.vb = (System.currentTimeMillis() - this.tR);
          localc.jA = ((float)localc.va * 1.0F / (float)localc.vb);
          if (this.tS != 0L) {
            break label443;
          }
        }
        break;
      }
      label443:
      for (long l = this.tR - meu.this.enterTime;; l = this.tR - this.tS)
      {
        localc.uZ = l;
        localc.agt = (meu.a(meu.this)[0] + "_" + meu.a(meu.this)[1] + "_" + meu.a(meu.this)[2] + "_" + meu.a(meu.this)[3]);
        localc.kP = new ArrayList(this.kQ);
        meu.this.iF.add(localc);
        this.tS = System.currentTimeMillis();
        this.aml = false;
        return;
        this.kQ.clear();
        this.map.clear();
        meu.this.amh = true;
        this.aml = true;
        this.maxHeight = 0;
        this.tR = System.currentTimeMillis();
        if (this.tQ == 0L) {
          this.tQ = this.tR;
        }
        meu.a(meu.this, paramAbsListView, false);
        a(true, false, paramAbsListView);
        return;
        paramInt = 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     meu
 * JD-Core Version:    0.7.0.1
 */