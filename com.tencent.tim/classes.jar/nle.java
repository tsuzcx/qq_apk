import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.10;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.5;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.6;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.7;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.8;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.9;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class nle
  extends BaseAdapter
  implements aryx, nlo, nlp
{
  private aqdf jdField_a_of_type_Aqdf;
  private nln[] jdField_a_of_type_ArrayOfNln;
  private int aZP = 16;
  private int aZQ = 18;
  private int aZR = -1;
  View.OnClickListener cp = new nlf(this);
  private float kA = 14.0F;
  private List<BaseData> kj;
  private Context mContext;
  private int mTextColor;
  private float mTextSize;
  
  public nle(Context paramContext, List<BaseData> paramList, aqdf paramaqdf)
  {
    this.kj = paramList;
    this.mContext = paramContext;
    this.jdField_a_of_type_Aqdf = paramaqdf;
    aZo();
    aZp();
  }
  
  private int a(int paramInt, View paramView)
  {
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(this.aZR, -2147483648), 0);
      paramInt = paramView.getMeasuredHeight();
      return paramInt;
    }
    catch (Exception paramView)
    {
      QLog.d("WebFastAdapter", 1, paramView, new Object[] { " getItemMeasureHeight error! msg=" + paramView });
    }
    return 0;
  }
  
  private void aZo()
  {
    nmh localnmh = new nmh();
    nmn localnmn = new nmn(this.mContext);
    this.jdField_a_of_type_ArrayOfNln = new nln[] { localnmn, new nlq(), new nlr(), new nlz(), new klh(), new nlw(), new klk(), new kln(), new klq(), localnmh };
    localnmh.g(this);
    localnmh.cm(this.mContext);
    localnmn.aZw();
    arvv.a().a(this);
  }
  
  private void aZp()
  {
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(String.valueOf(awit.y("local_kd_native_main_text_style")));
        localIterator = localJSONObject.keys();
        boolean bool = localIterator.hasNext();
        if (!bool) {}
      }
      catch (Exception localException1)
      {
        try
        {
          JSONObject localJSONObject;
          Iterator localIterator;
          String str1 = (String)localIterator.next();
          String str2 = localJSONObject.getString(str1);
          if ("native_main_text_color".equalsIgnoreCase(str1))
          {
            this.mTextColor = Color.parseColor(str2);
            continue;
          }
          if ("native_main_text_size".equalsIgnoreCase(str1))
          {
            this.mTextSize = Integer.valueOf(str2).intValue();
            this.mTextSize = Utils.dp2px(Double.valueOf(this.mTextSize).doubleValue());
            continue;
          }
          if ("native_main_text_row_space".equalsIgnoreCase(str1))
          {
            this.kA = Integer.valueOf(str2).intValue();
            continue;
          }
          if ("native_main_text_segment_space".equalsIgnoreCase(str1))
          {
            this.aZP = Integer.valueOf(str2).intValue();
            continue;
          }
          if (!"native_main_text_margin_side".equalsIgnoreCase(str1)) {
            continue;
          }
          this.aZQ = Integer.valueOf(str2).intValue();
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
      return;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    BaseData localBaseData = (BaseData)this.kj.get(paramInt);
    if (localBaseData == null)
    {
      wja.a("Q.readinjoy.fast_web", "", new NullPointerException());
      paramViewGroup = new TextView(this.mContext);
    }
    do
    {
      do
      {
        do
        {
          return paramViewGroup;
          try
          {
            localBaseData.pos = paramInt;
            if (paramView != null) {
              break label263;
            }
            paramView = a(localBaseData);
            if (paramView == null) {
              break;
            }
            paramView = paramView.a(this.mContext, localBaseData, paramViewGroup);
            paramView.a(this);
            paramViewGroup = paramView.itemView;
            paramViewGroup.setTag(paramView);
            localObject = paramView;
            paramView = paramViewGroup;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              QLog.d("WebFastAdapter", 1, "getView error,msg:" + paramView.toString());
              paramView = new View(this.mContext);
              paramView.setVisibility(8);
              continue;
              paramViewGroup = (nlm)paramView.getTag();
              Object localObject = paramViewGroup;
            }
          }
          ((nlm)localObject).textSize = this.mTextSize;
          ((nlm)localObject).kE = this.kA;
          ((nlm)localObject).bao = this.aZP;
          ((nlm)localObject).bap = this.aZQ;
          ((nlm)localObject).textColor = this.mTextColor;
          ((nlm)localObject).b(((nlm)localObject).g, localBaseData, paramBoolean);
          paramViewGroup = paramView;
        } while (this.aZR <= 0);
        paramViewGroup = paramView;
      } while (localBaseData.viewHeight > 0);
      paramInt = a(paramInt, paramView);
      paramViewGroup = paramView;
    } while (paramInt <= 0);
    localBaseData.viewHeight = paramInt;
    return paramView;
    throw new NullPointerException();
  }
  
  public nln a(BaseData paramBaseData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNln.length)
    {
      if (this.jdField_a_of_type_ArrayOfNln[i].a(paramBaseData)) {
        return this.jdField_a_of_type_ArrayOfNln[i];
      }
      i += 1;
    }
    throw new IllegalArgumentException("no suitable creator: " + paramBaseData.type);
  }
  
  public void aEe()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNln.length)
    {
      if ((this.jdField_a_of_type_ArrayOfNln[i] instanceof nlp)) {
        ((nlp)this.jdField_a_of_type_ArrayOfNln[i]).aEe();
      }
      i += 1;
    }
    arvv.a().b(this);
  }
  
  public List<BaseData> bi()
  {
    return this.kj;
  }
  
  public void c(BaseData paramBaseData) {}
  
  public int getCount()
  {
    if (this.kj != null) {
      return this.kj.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.kj != null) {
      return (BaseData)this.kj.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.kj == null) || (paramInt < 0) || (paramInt >= this.kj.size())) {
      return -1;
    }
    BaseData localBaseData = (BaseData)this.kj.get(paramInt);
    return a(localBaseData).a(localBaseData);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = a(paramInt, paramView, paramViewGroup, false);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return nlm.ban;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (!"com.tencent.reading".equals(paramString2)) {
      return;
    }
    ThreadManager.getUIHandler().post(new WebFastAdapter.9(this));
  }
  
  public void onCreate()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNln.length)
    {
      if ((this.jdField_a_of_type_ArrayOfNln[i] instanceof nlp)) {
        ((nlp)this.jdField_a_of_type_ArrayOfNln[i]).onCreate();
      }
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNln.length)
    {
      if ((this.jdField_a_of_type_ArrayOfNln[i] instanceof nlp)) {
        ((nlp)this.jdField_a_of_type_ArrayOfNln[i]).onDestroy();
      }
      i += 1;
    }
    arvv.a().b(this);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.6(this, paramDownloadInfo));
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.8(this, paramDownloadInfo));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.5(this, paramDownloadInfo));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.3(this, paramDownloadInfo));
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.7(this, paramList));
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.4(this, paramDownloadInfo));
  }
  
  public void onPause()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNln.length)
    {
      if ((this.jdField_a_of_type_ArrayOfNln[i] instanceof nlp)) {
        ((nlp)this.jdField_a_of_type_ArrayOfNln[i]).onPause();
      }
      i += 1;
    }
  }
  
  public void onResume()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNln.length)
    {
      if ((this.jdField_a_of_type_ArrayOfNln[i] instanceof nlp)) {
        ((nlp)this.jdField_a_of_type_ArrayOfNln[i]).onResume();
      }
      i += 1;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfNln.length)
    {
      if ((this.jdField_a_of_type_ArrayOfNln[i] instanceof nlp)) {
        ((nlp)this.jdField_a_of_type_ArrayOfNln[i]).onScrollStateChanged(paramAbsListView, paramInt);
      }
      i += 1;
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void tN(int paramInt)
  {
    this.aZR = paramInt;
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (!"com.tencent.reading".equals(paramString2)) {
      return;
    }
    ThreadManager.getUIHandler().post(new WebFastAdapter.10(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nle
 * JD-Core Version:    0.7.0.1
 */