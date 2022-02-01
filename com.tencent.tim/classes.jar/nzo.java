import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class nzo
  extends BaseAdapter
  implements aqdf.a, nzu.b
{
  public static int bdn;
  public static int bdo = 1;
  public static int bdp = 2;
  private static int bdq = 3;
  public static int bdr;
  public static int bds = 1;
  private boolean Wt;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private nzu jdField_a_of_type_Nzu;
  private oac jdField_a_of_type_Oac;
  private HashSet<String> ab = new HashSet();
  public boolean avO;
  public boolean avP;
  private boolean avQ;
  public int bdt = -1;
  public int bdu = -1;
  private final int bdv = 10;
  private int bdw;
  private HashMap<String, Bitmap> eA = new HashMap();
  private List<oal> kK = new ArrayList();
  private List<ReadInJoyArticle> kL = new ArrayList();
  private List<Object> kM = new ArrayList();
  private float lA;
  private float lu;
  private float lv;
  private float lz;
  private QQAppInterface mApp;
  private Activity mContext;
  private aajx mFaceDecoder;
  private LayoutInflater mLayoutInflater;
  private XListView mListView;
  private View.OnClickListener mOnClickListener;
  private Resources mResources;
  
  public nzo(Activity paramActivity, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.mContext = paramActivity;
    this.mResources = this.mContext.getResources();
    this.mApp = paramQQAppInterface;
    this.mListView = paramXListView;
    this.mLayoutInflater = paramLayoutInflater;
    this.mFaceDecoder = new aajx(paramQQAppInterface, this, false);
    this.Wt = ThemeUtil.isInNightMode(paramQQAppInterface);
    this.lz = this.mContext.getResources().getDimension(2131298407);
    this.lA = this.mContext.getResources().getDimension(2131298409);
    this.lu = this.mContext.getResources().getDimension(2131298408);
    this.lv = this.mContext.getResources().getDimension(2131298406);
  }
  
  private void a(nzo.a parama, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.eA.get(paramString);
    if (localBitmap == null)
    {
      parama.hE.setImageDrawable(this.mFaceDecoder.a(1008, paramString));
      return;
    }
    parama.hE.setImageBitmap(localBitmap);
  }
  
  public void a(nzu paramnzu)
  {
    this.jdField_a_of_type_Nzu = paramnzu;
  }
  
  public void a(oac paramoac)
  {
    this.jdField_a_of_type_Oac = paramoac;
  }
  
  public boolean a(ImageView paramImageView)
  {
    if (paramImageView.getTag(2131378986).equals(Integer.valueOf(bdo))) {
      return true;
    }
    if (paramImageView.getTag(2131378986).equals(Integer.valueOf(bdn)))
    {
      int j = this.mListView.getChildCount();
      int i = 0;
      if (i < j)
      {
        Object localObject = this.mListView.getChildAt(i).getTag();
        if ((localObject == null) || (!(localObject instanceof nzo.a))) {}
        while (!((nzo.a)localObject).uin.equals(paramImageView.getTag(2131378987)))
        {
          i += 1;
          break;
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  public void bcL()
  {
    int j = 1;
    int i;
    if ((this.bdt == 1) && (this.avO))
    {
      i = 1;
      if ((this.bdu != 1) || (!this.avP)) {
        break label134;
      }
      label34:
      this.kM.clear();
      this.kM.addAll(this.kK);
      if ((i != 0) && (this.kL.size() > 0))
      {
        if (this.kM.size() > 6) {
          break label139;
        }
        this.kM.add("ReadInJoyArticle");
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        if (this.kM.size() > 3) {
          break label155;
        }
        this.kM.add("SubscriptRecommendController");
      }
      return;
      i = 0;
      break;
      label134:
      j = 0;
      break label34;
      label139:
      this.kM.add(6, "ReadInJoyArticle");
    }
    label155:
    this.kM.add(3, "SubscriptRecommendController");
  }
  
  public void ds(List<oal> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.kK.clear();
    this.kK.addAll(paramList);
  }
  
  public void dt(List<ReadInJoyArticle> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.kL.clear();
    this.kL.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.kM.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.kM.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = bdq;
    Object localObject = this.kM.get(paramInt);
    if ((localObject instanceof oal)) {
      paramInt = bdn;
    }
    do
    {
      do
      {
        return paramInt;
        if (((localObject instanceof String)) && (localObject.equals("SubscriptRecommendController"))) {
          return bdp;
        }
        paramInt = i;
      } while (!(localObject instanceof String));
      paramInt = i;
    } while (!localObject.equals("ReadInJoyArticle"));
    return bdo;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramInt < 0) || (paramInt >= this.kM.size()))
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    int j = getItemViewType(paramInt);
    Object localObject2 = null;
    int i;
    if (paramView == null) {
      if (j == bdn)
      {
        localObject2 = new nzo.a();
        localObject1 = this.mLayoutInflater.inflate(2131560569, null);
        ((nzo.a)localObject2).cg = ((ViewGroup)((View)localObject1).findViewById(2131378975));
        ((nzo.a)localObject2).hE = ((ImageView)((View)localObject1).findViewById(2131378989));
        ((nzo.a)localObject2).tW = ((TextView)((View)localObject1).findViewById(2131378994));
        ((nzo.a)localObject2).tX = ((TextView)((View)localObject1).findViewById(2131377098));
        ((nzo.a)localObject2).a = ((DragTextView)((View)localObject1).findViewById(2131381284));
        ((nzo.a)localObject2).tY = ((TextView)((View)localObject1).findViewById(2131366907));
        ((nzo.a)localObject2).lk = ((ImageView)((View)localObject1).findViewById(2131366879));
        ((nzo.a)localObject2).ll = ((ImageView)((View)localObject1).findViewById(2131366883));
        ((nzo.a)localObject2).bZ = ((Button)((View)localObject1).findViewById(2131371300));
        ((nzo.a)localObject2).ca = ((Button)((View)localObject1).findViewById(2131371306));
        ((nzo.a)localObject2).bY = ((Button)((View)localObject1).findViewById(2131371305));
        ((nzo.a)localObject2).bL = ((Button)((View)localObject1).findViewById(2131371285));
        ((nzo.a)localObject2).cg.setOnClickListener(this.mOnClickListener);
        ((nzo.a)localObject2).a.setDragViewType(0, (View)localObject1);
        ((nzo.a)localObject2).a.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((nzo.a)localObject2).bZ.setOnClickListener(this.mOnClickListener);
        ((nzo.a)localObject2).ca.setOnClickListener(this.mOnClickListener);
        ((nzo.a)localObject2).bY.setOnClickListener(this.mOnClickListener);
        ((nzo.a)localObject2).bL.setOnClickListener(this.mOnClickListener);
        paramView = ((nzo.a)localObject2).tY;
        if (this.Wt)
        {
          i = this.mResources.getColor(2131166334);
          label382:
          paramView.setTextColor(i);
          paramView = ((nzo.a)localObject2).tW;
          if (!this.Wt) {
            break label493;
          }
          i = this.mResources.getColor(2131166340);
          label413:
          paramView.setTextColor(i);
          paramView = ((nzo.a)localObject2).tX;
          if (!this.Wt) {
            break label508;
          }
          i = this.mResources.getColor(2131166343);
          label444:
          paramView.setTextColor(i);
          label450:
          paramView = (View)localObject1;
          if (localObject1 != null)
          {
            ((View)localObject1).setTag(localObject2);
            paramView = (View)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        localObject1 = null;
        break;
        i = this.mResources.getColor(2131166333);
        break label382;
        label493:
        i = this.mResources.getColor(2131166339);
        break label413;
        label508:
        i = this.mResources.getColor(2131166342);
        break label444;
        if (j == bdo)
        {
          localObject2 = new nzo.b(null);
          localObject1 = this.mLayoutInflater.inflate(2131560571, null);
          ((nzo.b)localObject2).ch = ((ViewGroup)((View)localObject1).findViewById(2131370025));
          ((nzo.b)localObject2).ch.setOnClickListener(this.mOnClickListener);
          paramView = (TextView)((nzo.b)localObject2).ch.findViewById(2131370026);
          int k;
          if (!this.Wt)
          {
            i = 2130844032;
            paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            ((nzo.b)localObject2).lU.add((ViewGroup)((View)localObject1).findViewById(2131370008));
            ((nzo.b)localObject2).lU.add((ViewGroup)((View)localObject1).findViewById(2131370009));
            ((nzo.b)localObject2).lU.add((ViewGroup)((View)localObject1).findViewById(2131370010));
            ((nzo.b)localObject2).lU.add((ViewGroup)((View)localObject1).findViewById(2131370011));
            k = ((nzo.b)localObject2).lU.size();
            paramView = this.mResources;
            if (this.Wt) {
              break label807;
            }
          }
          label807:
          for (i = 2131166349;; i = 2131166350)
          {
            int m = paramView.getColor(i);
            i = 0;
            while (i < k)
            {
              paramView = (ViewGroup)((nzo.b)localObject2).lU.get(i);
              paramView.setOnClickListener(this.mOnClickListener);
              paramView.setTag(Integer.valueOf(i));
              ((TextView)paramView.findViewById(2131363017)).setTextColor(m);
              i += 1;
            }
            i = 2130844033;
            break;
          }
          ((View)localObject1).setTag(-3, Integer.valueOf(0));
          break label450;
        }
        if (j != bdp) {
          break label2153;
        }
        localObject2 = new nzo.c(null);
        localObject1 = this.mLayoutInflater.inflate(2131560573, null);
        this.jdField_a_of_type_Oac.dq((View)localObject1);
        this.jdField_a_of_type_Oac.bcP();
        this.jdField_a_of_type_Oac.update();
        ((View)localObject1).setTag(-3, Integer.valueOf(0));
        this.avQ = true;
        break label450;
      }
      Object localObject3;
      label1016:
      Object localObject4;
      if (j == bdn)
      {
        paramView.setTag(2131378981, Integer.valueOf(paramInt));
        localObject1 = (nzo.a)paramView.getTag();
        localObject2 = (oal)getItem(paramInt);
        if (this.ab != null) {
          this.ab.add(((oal)localObject2).mUin);
        }
        ((nzo.a)localObject1).uin = ((oal)localObject2).mUin;
        a((nzo.a)localObject1, ((oal)localObject2).mUin);
        localObject3 = oan.a().getNickName(((oal)localObject2).mUin);
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          ((nzo.a)localObject1).tW.setText(((oal)localObject2).mUin);
          ((nzo.a)localObject1).tX.setText(aale.a().t(((oal)localObject2).mUin, ((oal)localObject2).yu));
          if (((oal)localObject2).aOr <= 0) {
            break label1418;
          }
          i = 3;
          label1051:
          aute.updateCustomNoteTxt(((nzo.a)localObject1).a, i, ((oal)localObject2).aOr, 2130851404, 99, null);
          if (((oal)localObject2).mItems.size() <= 0) {
            break label1801;
          }
          localObject4 = (oam)((oal)localObject2).mItems.get(0);
          if (((oam)localObject4).type != 0) {
            break label1424;
          }
          ((nzo.a)localObject1).tY.setMaxLines(1);
          ((nzo.a)localObject1).tY.setText(new aofk(((oam)localObject4).aoP.replaceFirst("^\\s+", ""), 3, 20));
          ((nzo.a)localObject1).lk.setVisibility(8);
          ((nzo.a)localObject1).ll.setVisibility(8);
          label1170:
          ((nzo.a)localObject1).cg.setTag(2131378978, Integer.valueOf(((oal)localObject2).aOr));
          ((nzo.a)localObject1).cg.setTag(2131378987, ((oal)localObject2).mUin);
          ((nzo.a)localObject1).cg.setTag(2131378980, localObject3);
          ((nzo.a)localObject1).cg.setTag(2131378979, Integer.valueOf(bdr));
          ((nzo.a)localObject1).a.setTag(2131378978, localObject2);
          ((nzo.a)localObject1).bZ.setTag(2131378987, ((oal)localObject2).mUin);
          ((nzo.a)localObject1).ca.setTag(2131378987, ((oal)localObject2).mUin);
          ((nzo.a)localObject1).bY.setTag(2131378987, ((oal)localObject2).mUin);
          ((nzo.a)localObject1).bY.setTag(2131378980, localObject3);
          ((nzo.a)localObject1).bL.setTag(2131378987, ((oal)localObject2).mUin);
          if (oan.a().a(((oal)localObject2).mUin, this.mApp)) {
            break label1840;
          }
          if (this.Wt) {
            break label1826;
          }
          ((nzo.a)localObject1).cg.setBackgroundResource(2130844028);
          label1356:
          paramView.setTag(-3, Integer.valueOf((int)(this.lz + this.lu + this.lv)));
          ((nzo.a)localObject1).bZ.setVisibility(0);
          ((nzo.a)localObject1).ca.setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        ((nzo.a)localObject1).tW.setText((CharSequence)localObject3);
        break label1016;
        label1418:
        i = 0;
        break label1051;
        label1424:
        ViewGroup.LayoutParams localLayoutParams;
        if (((oam)localObject4).type == 1)
        {
          ((nzo.a)localObject1).tY.setMaxLines(2);
          ((nzo.a)localObject1).tY.setText(((oam)localObject4).title.replaceFirst("^\\s+", ""));
          ((nzo.a)localObject1).lk.setVisibility(0);
          if (TextUtils.isEmpty(((oam)localObject4).tagName)) {
            ((nzo.a)localObject1).ll.setVisibility(8);
          }
          for (;;)
          {
            ((nzo.a)localObject1).lk.setTag(2131378987, ((nzo.a)localObject1).uin);
            ((nzo.a)localObject1).lk.setTag(2131378986, Integer.valueOf(bdn));
            localLayoutParams = ((nzo.a)localObject1).lk.getLayoutParams();
            this.jdField_a_of_type_Nzu.a(obs.a(((oam)localObject4).coverUrl, 1, ((oal)localObject2).mUin), ((nzo.a)localObject1).lk, localLayoutParams.width, localLayoutParams.height, this);
            if (!(((nzo.a)localObject1).lk.getDrawable() instanceof URLDrawable)) {
              break;
            }
            localObject4 = (URLDrawable)((nzo.a)localObject1).lk.getDrawable();
            if (paramInt < 10) {
              break;
            }
            ((URLDrawable)localObject4).setAutoDownload(false);
            break;
            ((nzo.a)localObject1).ll.setVisibility(0);
          }
        }
        if (((oam)localObject4).type == 2)
        {
          ((nzo.a)localObject1).tY.setMaxLines(1);
          ((nzo.a)localObject1).tY.setText(2131698744);
          ((nzo.a)localObject1).lk.setVisibility(0);
          ((nzo.a)localObject1).ll.setVisibility(8);
          ((nzo.a)localObject1).lk.setTag(2131378987, ((nzo.a)localObject1).uin);
          ((nzo.a)localObject1).lk.setTag(2131378986, Integer.valueOf(bdn));
          localLayoutParams = ((nzo.a)localObject1).lk.getLayoutParams();
          this.jdField_a_of_type_Nzu.a(obs.a(((oam)localObject4).i.toString(), 1, ((oal)localObject2).mUin), ((nzo.a)localObject1).lk, localLayoutParams.width, localLayoutParams.height, this);
          break label1170;
        }
        ((nzo.a)localObject1).tY.setMaxLines(1);
        ((nzo.a)localObject1).tY.setText(2131698745);
        ((nzo.a)localObject1).lk.setVisibility(8);
        ((nzo.a)localObject1).ll.setVisibility(8);
        break label1170;
        label1801:
        if ((!QLog.isColorLevel()) || (!QLog.isColorLevel())) {
          break label1170;
        }
        QLog.w("SubscriptFeedsAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
        break label1170;
        label1826:
        ((nzo.a)localObject1).cg.setBackgroundResource(2130844030);
        break label1356;
        label1840:
        if (!this.Wt) {
          ((nzo.a)localObject1).cg.setBackgroundResource(2130844029);
        }
        for (;;)
        {
          paramView.setTag(-3, Integer.valueOf((int)(this.lA + this.lu + this.lv)));
          ((nzo.a)localObject1).bZ.setVisibility(8);
          ((nzo.a)localObject1).ca.setVisibility(0);
          break;
          ((nzo.a)localObject1).cg.setBackgroundResource(2130844031);
        }
        if (j == bdo)
        {
          paramView.setTag(2131378981, Integer.valueOf(paramInt));
          this.bdw += 1;
          localObject1 = (nzo.b)paramView.getTag();
          j = ((nzo.b)localObject1).lU.size();
          i = 0;
          while (i < j)
          {
            localObject3 = (ViewGroup)((nzo.b)localObject1).lU.get(i);
            localObject2 = (TextView)((ViewGroup)localObject3).findViewById(2131363017);
            localObject3 = (ImageView)((ViewGroup)localObject3).findViewById(2131363016);
            if (i < this.kL.size())
            {
              localObject4 = (ReadInJoyArticle)this.kL.get(i);
              ((TextView)localObject2).setText(((ReadInJoyArticle)localObject4).mTitle.replaceFirst("^\\s+", ""));
              ((ImageView)localObject3).setTag(2131378986, Integer.valueOf(bdo));
              localObject2 = (WindowManager)this.mContext.getSystemService("window");
              this.jdField_a_of_type_Nzu.a(obs.a(((ReadInJoyArticle)localObject4).mFirstPagePicUrl, 1), (ImageView)localObject3, ((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight(), this);
            }
            i += 1;
          }
        }
        else if (j != bdp) {}
      }
      label2153:
      localObject1 = paramView;
      break label450;
    }
  }
  
  public int getViewTypeCount()
  {
    return bdq;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.mListView == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      this.eA.put(paramString, paramBitmap);
      paramInt2 = this.mListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.mListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof nzo.a)))
        {
          paramBitmap = (nzo.a)paramBitmap;
          if (paramString.equals(paramBitmap.uin)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestory()
  {
    if (!this.ab.isEmpty()) {
      anot.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.ab.size(), 0, "", "", "", "");
    }
    if (this.bdw > 0) {
      anot.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.bdw, 0, "", "", "", "");
    }
    if (this.avQ) {
      anot.a(this.mApp, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.ab.clear();
    this.ab = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = null;
    this.jdField_a_of_type_Nzu = null;
    this.jdField_a_of_type_Oac = null;
    this.mFaceDecoder.onDestory();
    this.mLayoutInflater = null;
    this.mListView = null;
    this.eA.clear();
    this.eA = null;
    this.mResources = null;
    this.mContext = null;
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public class a
  {
    DragTextView a;
    Button bL;
    Button bY;
    Button bZ;
    Button ca;
    ViewGroup cg;
    ImageView hE;
    ImageView lk;
    ImageView ll;
    TextView tW;
    TextView tX;
    TextView tY;
    String uin;
    
    public a() {}
  }
  
  class b
  {
    ViewGroup ch;
    ArrayList<ViewGroup> lU = new ArrayList();
    
    private b() {}
  }
  
  class c
  {
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzo
 * JD-Core Version:    0.7.0.1
 */