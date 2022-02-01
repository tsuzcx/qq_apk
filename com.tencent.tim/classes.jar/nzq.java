import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class nzq
  extends BaseAdapter
  implements aqdf.a
{
  public static int bdn;
  private static int bdq = 3;
  public static int bdr;
  public static int bds = 1;
  public static int bdx = 1;
  private boolean Wt;
  private DragFrameLayout a;
  private HashSet<String> ab = new HashSet();
  private boolean avQ;
  private KandianMergeManager b;
  private int bdw;
  private HashMap<String, Bitmap> eA = new HashMap();
  private List<oal> kK = new ArrayList();
  private List<Object> kM = new ArrayList();
  private List<nzq.b> kN = new ArrayList();
  private float lA;
  private float lu;
  private float lv;
  private float lz;
  private QQAppInterface mApp;
  private Context mContext;
  private aajx mFaceDecoder;
  private LayoutInflater mLayoutInflater;
  private XListView mListView;
  private View.OnClickListener mOnClickListener;
  private Resources mResources;
  
  public nzq(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, LayoutInflater paramLayoutInflater)
  {
    this.mContext = paramContext;
    this.mResources = this.mContext.getResources();
    this.mApp = paramQQAppInterface;
    this.mListView = paramXListView;
    this.mLayoutInflater = paramLayoutInflater;
    this.mFaceDecoder = new aajx(paramQQAppInterface, this, false);
    this.lz = this.mContext.getResources().getDimension(2131298407);
    this.lA = this.mContext.getResources().getDimension(2131298409);
    this.lu = this.mContext.getResources().getDimension(2131298408);
    this.lv = this.mContext.getResources().getDimension(2131298406);
    this.b = ((KandianMergeManager)this.mApp.getManager(162));
    bcM();
  }
  
  private void a(nzq.a parama, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.eA.get(paramString);
    if (localBitmap == null)
    {
      parama.hE.setImageDrawable(this.mFaceDecoder.a(1008, paramString));
      return;
    }
    parama.hE.setImageBitmap(localBitmap);
  }
  
  public void bcL()
  {
    this.kM.clear();
    this.kM.addAll(this.kN);
    this.kM.addAll(this.kK);
  }
  
  public void bcM()
  {
    if (this.kN.size() > 0) {
      this.kN.clear();
    }
    ArrayList localArrayList = new ArrayList();
    this.kN.addAll(localArrayList);
  }
  
  public void ds(List<oal> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.kK.clear();
    this.kK.addAll(paramList);
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
      return paramInt;
      paramInt = i;
    } while (!(localObject instanceof nzq.b));
    return bdx;
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
        localObject2 = new nzq.a();
        localObject1 = this.mLayoutInflater.inflate(2131560570, null);
        ((nzq.a)localObject2).cg = ((ViewGroup)((View)localObject1).findViewById(2131378975));
        ((nzq.a)localObject2).hE = ((ImageView)((View)localObject1).findViewById(2131378989));
        ((nzq.a)localObject2).tW = ((TextView)((View)localObject1).findViewById(2131378994));
        ((nzq.a)localObject2).tX = ((TextView)((View)localObject1).findViewById(2131377098));
        ((nzq.a)localObject2).a = ((DragTextView)((View)localObject1).findViewById(2131381284));
        ((nzq.a)localObject2).tY = ((TextView)((View)localObject1).findViewById(2131366907));
        ((nzq.a)localObject2).bY = ((Button)((View)localObject1).findViewById(2131371305));
        ((nzq.a)localObject2).bL = ((Button)((View)localObject1).findViewById(2131371285));
        ((nzq.a)localObject2).cg.setOnClickListener(this.mOnClickListener);
        ((nzq.a)localObject2).a.setDragViewType(0, (View)localObject1);
        ((nzq.a)localObject2).a.setOnModeChangeListener(this.a);
        ((nzq.a)localObject2).bY.setOnClickListener(this.mOnClickListener);
        ((nzq.a)localObject2).bL.setOnClickListener(this.mOnClickListener);
        paramView = ((nzq.a)localObject2).tY;
        if (this.Wt)
        {
          i = this.mResources.getColor(2131166334);
          label287:
          paramView.setTextColor(i);
          paramView = ((nzq.a)localObject2).tW;
          if (!this.Wt) {
            break label406;
          }
          i = this.mResources.getColor(2131166340);
          label318:
          paramView.setTextColor(i);
          paramView = ((nzq.a)localObject2).tX;
          if (!this.Wt) {
            break label421;
          }
          i = this.mResources.getColor(2131166343);
          label349:
          paramView.setTextColor(i);
          label355:
          paramView = (View)localObject1;
          if (localObject1 != null)
          {
            paramView = (View)localObject1;
            if (localObject2 != null)
            {
              ((View)localObject1).setTag(localObject2);
              paramView = (View)localObject1;
            }
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
        i = this.mResources.getColor(2131166339);
        break label287;
        label406:
        i = this.mResources.getColor(2131166333);
        break label318;
        label421:
        i = this.mResources.getColor(2131166342);
        break label349;
        if (j != bdx) {
          break label1255;
        }
        localObject1 = this.mLayoutInflater.inflate(2131560189, null);
        break label355;
      }
      if (j == bdn)
      {
        paramView.setTag(2131378981, Integer.valueOf(paramInt));
        localObject2 = (nzq.a)paramView.getTag();
        localoal = (oal)getItem(paramInt);
        if (this.ab != null) {
          this.ab.add(localoal.mUin);
        }
        ((nzq.a)localObject2).uin = localoal.mUin;
        a((nzq.a)localObject2, localoal.mUin);
        localObject1 = oan.a().getNickName(localoal.mUin);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = oan.a().a(localoal.mUin, this.mApp);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ((nzq.a)localObject2).tW.setText((CharSequence)localObject1);
            ((nzq.a)localObject2).tX.setText(aale.a().t(localoal.mUin, localoal.yu));
            if (localoal.aOr <= 0) {
              break label916;
            }
            i = 3;
            aute.updateCustomNoteTxt(((nzq.a)localObject2).a, i, localoal.aOr, 2130851404, 99, null);
            if (localoal.mItems.size() <= 0) {
              break label1020;
            }
            localoam = (oam)localoal.mItems.get(0);
            if (localoam.type != 0) {
              break label922;
            }
            ((nzq.a)localObject2).tY.setMaxLines(1);
            ((nzq.a)localObject2).tY.setText(new aofk(localoam.aoP.replaceFirst("^\\s+", ""), 3, 20));
            ((nzq.a)localObject2).cg.setTag(2131378978, Integer.valueOf(localoal.aOr));
            ((nzq.a)localObject2).cg.setTag(2131378987, localoal.mUin);
            ((nzq.a)localObject2).cg.setTag(2131378980, localObject1);
            ((nzq.a)localObject2).cg.setTag(2131378979, Integer.valueOf(bdr));
            ((nzq.a)localObject2).cg.setTag(localoal);
            ((nzq.a)localObject2).a.setTag(2131378978, localoal);
            ((nzq.a)localObject2).bY.setTag(2131378987, localoal.mUin);
            ((nzq.a)localObject2).bY.setTag(2131378980, localObject1);
            ((nzq.a)localObject2).bL.setTag(2131378987, localoal.mUin);
            paramView.setTag(-3, Integer.valueOf((int)(this.lu + this.lv)));
          }
        }
      }
      label916:
      label922:
      label1020:
      while (j != bdx) {
        for (;;)
        {
          oal localoal;
          oam localoam;
          localObject1 = paramView;
          break;
          ((nzq.a)localObject2).tW.setText(localoal.mUin);
          continue;
          ((nzq.a)localObject2).tW.setText((CharSequence)localObject1);
          continue;
          i = 0;
          continue;
          if (localoam.type == 1)
          {
            ((nzq.a)localObject2).tY.setMaxLines(2);
            ((nzq.a)localObject2).tY.setText(localoam.title.replaceFirst("^\\s+", ""));
          }
          else if (localoam.type == 2)
          {
            ((nzq.a)localObject2).tY.setMaxLines(1);
            ((nzq.a)localObject2).tY.setText(2131698744);
          }
          else
          {
            ((nzq.a)localObject2).tY.setMaxLines(1);
            ((nzq.a)localObject2).tY.setText(2131698745);
            continue;
            if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
              QLog.w("SubscriptFeedsNewAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
            }
          }
        }
      }
      localObject1 = (nzq.b)getItem(paramInt);
      ((TextView)paramView.findViewById(2131371992)).setText(((nzq.b)localObject1).name);
      ((ImageView)paramView.findViewById(2131371991)).setImageDrawable(((nzq.b)localObject1).iconDrawable);
      localObject2 = (DragTextView)paramView.findViewById(2131381284);
      ((DragTextView)localObject2).setDragViewType(0, paramView);
      if (((nzq.b)localObject1).unReadCount > 0) {}
      for (i = 3;; i = 0)
      {
        aute.updateCustomNoteTxt((TextView)localObject2, i, ((nzq.b)localObject1).unReadCount, 2130851404, 99, null);
        if (((nzq.b)localObject1).unReadCount > 0) {
          paramView.findViewById(2131362995).setVisibility(8);
        }
        localObject2 = (ViewGroup)paramView.findViewById(2131371990);
        ((ViewGroup)localObject2).setTag(2131378979, Integer.valueOf(bds));
        ((ViewGroup)localObject2).setTag(2131379238, ((nzq.b)localObject1).jumpUrl);
        ((ViewGroup)localObject2).setTag(2131376668, Integer.valueOf(((nzq.b)localObject1).type));
        ((ViewGroup)localObject2).setTag(2131376669, Integer.valueOf(((nzq.b)localObject1).unReadCount));
        ((ViewGroup)localObject2).setOnClickListener(this.mOnClickListener);
        break;
      }
      label1255:
      localObject1 = paramView;
      break label355;
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
        if ((paramBitmap != null) && ((paramBitmap instanceof nzq.a)))
        {
          paramBitmap = (nzq.a)paramBitmap;
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
    if (!this.ab.isEmpty())
    {
      anot.b(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.ab.size(), 0, "", "", "", "");
      Iterator localIterator = this.ab.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label144;
        }
        String str = (String)localIterator.next();
        Object localObject1 = "";
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("folder_status", kxm.aMw);
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        kbp.a(null, str, "0X80081C7", "0X80081C7", 0, 0, "", "", "", (String)localObject1, false);
      }
    }
    label144:
    if (this.bdw > 0) {
      anot.b(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, this.bdw, 0, "", "", "", "");
    }
    if (this.avQ) {
      anot.a(this.mApp, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
    this.ab.clear();
    this.ab = null;
    this.a = null;
    this.mFaceDecoder.onDestory();
    this.mLayoutInflater = null;
    this.mListView = null;
    this.eA.clear();
    this.eA = null;
    this.mResources = null;
    this.mContext = null;
    this.kN.clear();
    this.kN = null;
  }
  
  public void setDragHost(DragFrameLayout paramDragFrameLayout)
  {
    this.a = paramDragFrameLayout;
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
    ViewGroup cg;
    ImageView hE;
    TextView tW;
    TextView tX;
    TextView tY;
    String uin;
    
    public a() {}
  }
  
  public class b
  {
    Drawable iconDrawable;
    String jumpUrl;
    String name;
    int type;
    int unReadCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzq
 * JD-Core Version:    0.7.0.1
 */