import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqv
{
  private aorm a;
  private ValueAnimator aK;
  private ValueAnimator aL;
  private boolean cOf;
  private boolean cOg;
  private int dRs;
  private int dRt;
  private ListView mListView;
  
  public aoqv(ListView paramListView, aorm paramaorm, List<aorm.d> paramList)
  {
    this.mListView = paramListView;
    this.a = paramaorm;
    this.a.mF(paramList);
    b(this.mListView);
    paramaorm = this.mListView.getLayoutParams();
    paramaorm.height = this.dRs;
    paramaorm.width = this.dRt;
    paramListView.setLayoutParams(paramaorm);
    this.mListView.setPadding(aqcx.dip2px(this.mListView.getContext(), 8.0F), -this.dRs, 0, 0);
  }
  
  private void dWC()
  {
    this.aK = ValueAnimator.ofInt(new int[] { -this.dRs, 0 });
    this.aK.setDuration(100L);
    this.aK.addUpdateListener(new aoqw(this));
    this.aK.addListener(new aoqx(this));
  }
  
  private void dWD()
  {
    this.aL = ValueAnimator.ofInt(new int[] { 0, -this.dRs });
    this.aL.setDuration(100L);
    this.aL.addUpdateListener(new aoqy(this));
    this.aL.addListener(new aoqz(this));
  }
  
  public static List<aorm.d> i(JSONArray paramJSONArray)
    throws JSONException
  {
    if (paramJSONArray == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TribePostTitlePrefixPanelController", 2, "prefixJArray is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        aorm.d locald = new aorm.d();
        try
        {
          locald.ak(localJSONObject);
          if (locald.isValid()) {
            localArrayList.add(locald);
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("TribePostTitlePrefixPanelController", 2, "analyze error , " + localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean aAw()
  {
    return (this.mListView.getVisibility() != 0) || (this.cOg);
  }
  
  public void b(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int k = localListAdapter.getCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      View localView = localListAdapter.getView(i, null, paramListView);
      localView.measure(0, 0);
      j += localView.getMeasuredHeight();
      int m = localView.getMeasuredWidth();
      if (m > this.dRt) {
        this.dRt = m;
      }
      i += 1;
    }
    this.dRs = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
    this.dRt += aqcx.dip2px(this.mListView.getContext(), 8.0F);
  }
  
  public void hide()
  {
    if ((isShow()) && (!this.cOf))
    {
      if (this.aL == null) {
        dWD();
      }
      this.aL.setInterpolator(new LinearInterpolator());
      this.aL.start();
      this.cOg = true;
    }
  }
  
  public boolean isShow()
  {
    return this.mListView.getVisibility() == 0;
  }
  
  public void onDestroy()
  {
    if (this.aK != null) {
      this.aK.cancel();
    }
    if (this.aL != null) {
      this.aL.cancel();
    }
  }
  
  public void show()
  {
    if ((!isShow()) && (!this.cOf))
    {
      this.mListView.setVisibility(0);
      if (this.aK == null) {
        dWC();
      }
      this.aK.setInterpolator(new BounceInterpolator());
      this.aK.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqv
 * JD-Core Version:    0.7.0.1
 */