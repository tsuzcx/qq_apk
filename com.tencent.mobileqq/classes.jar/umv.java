import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class umv
  extends ViewBase
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new umw(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private List<umy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Queue<String> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private TextView b;
  private TextView c;
  
  public umv(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131560091, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362029));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362030));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362031));
    umy localumy1 = new umy(this.jdField_a_of_type_AndroidWidgetTextView, 0, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    umy localumy2 = new umy(this.b, -1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    umy localumy3 = new umy(this.c, -2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilQueue);
    this.jdField_a_of_type_JavaUtilList.add(localumy1);
    this.jdField_a_of_type_JavaUtilList.add(localumy2);
    this.jdField_a_of_type_JavaUtilList.add(localumy3);
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((umy)localIterator.next()).a();
    }
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo;
    if (localObject == null)
    {
      ukq.a("ReadInJoyAdBubbleView", "adExtInfo is empty");
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject).optJSONArray("ad_bubble_texts");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        ukq.a("ReadInJoyAdBubbleView", "parseBuuble JSONArray is empty");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
      int i = 0;
      while (i < localException.length())
      {
        String str = (String)localException.get(i);
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_JavaUtilQueue.offer(str);
        }
        i += 1;
      }
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      umy localumy = (umy)localIterator.next();
      localumy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localumy.jdField_a_of_type_Int = i;
      i -= 1;
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView) {}
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        try
        {
          if ((paramObject instanceof AdvertisementInfo))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
            c();
            return true;
          }
        }
        catch (Exception paramObject)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
          QLog.d("ReadInJoyAdBubbleView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umv
 * JD-Core Version:    0.7.0.1
 */