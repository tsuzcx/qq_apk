import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.datareportviewer.DataReportViewerFloatViewHelper.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afbx
  implements View.OnTouchListener
{
  private static afbx jdField_a_of_type_Afbx;
  public static boolean bXd = true;
  private DataReportViewer jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer;
  private int cPZ;
  private BroadcastReceiver mBroadcastReceiver = new afby(this);
  private boolean mIsAttached;
  private boolean mIsDragging;
  private boolean mIsEnable;
  private HashMap<String, afbz> mMap = new HashMap();
  private WindowManager mWindowManager;
  private ArrayList<afbe> vV;
  
  /* Error */
  public static afbx a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 49	afbx:jdField_a_of_type_Afbx	Lafbx;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	afbx
    //   15: dup
    //   16: invokespecial 50	afbx:<init>	()V
    //   19: putstatic 49	afbx:jdField_a_of_type_Afbx	Lafbx;
    //   22: ldc 2
    //   24: monitorexit
    //   25: ldc 2
    //   27: monitorexit
    //   28: getstatic 49	afbx:jdField_a_of_type_Afbx	Lafbx;
    //   31: areturn
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	5	0	localObject1	Object
    //   38	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	32	finally
    //   33	36	32	finally
    //   3	12	38	finally
    //   25	28	38	finally
    //   36	38	38	finally
    //   39	42	38	finally
  }
  
  public void D(Context paramContext, boolean paramBoolean)
  {
    this.mIsEnable = paramBoolean;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("DataReportViewerFloatViewHelper", paramBoolean);
    paramContext.apply();
  }
  
  public void a(afbe paramafbe)
  {
    this.vV.add(paramafbe);
    cYr();
    if ((paramafbe instanceof afbz)) {
      this.mMap.put(((afbz)paramafbe).action, (afbz)paramafbe);
    }
  }
  
  public void b(afbe paramafbe)
  {
    this.vV.remove(paramafbe);
    cYr();
    if ((paramafbe instanceof afbz)) {
      this.mMap.remove(((afbz)paramafbe).action);
    }
    for (;;)
    {
      return;
      if ((paramafbe instanceof afca))
      {
        paramafbe = ((afca)paramafbe).vW.iterator();
        while (paramafbe.hasNext())
        {
          afbz localafbz = (afbz)paramafbe.next();
          this.mMap.remove(localafbz.action);
        }
      }
    }
  }
  
  public ArrayList<afbe> cU()
  {
    Object localObject1;
    if (this.vV == null)
    {
      this.vV = new ArrayList(10);
      localObject1 = BaseApplication.getContext().getFileStreamPath("DataReportConfigs");
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        localObject1 = aqhq.readFileContent((File)localObject1);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (TextUtils.isEmpty(((JSONObject)localObject2).optString("group")))
          {
            localObject2 = afbz.a((JSONObject)localObject2);
            this.vV.add(localObject2);
            this.mMap.put(((afbz)localObject2).action, localObject2);
          }
          else
          {
            localObject2 = afca.a((JSONObject)localObject2);
            this.vV.add(localObject2);
            localObject2 = ((afca)localObject2).vW.iterator();
            if (((Iterator)localObject2).hasNext())
            {
              afbz localafbz = (afbz)((Iterator)localObject2).next();
              this.mMap.put(localafbz.action, localafbz);
              continue;
            }
          }
        }
        else
        {
          return this.vV;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i += 1;
    }
  }
  
  public void cYr()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.vV.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((afbe)localIterator.next()).toJson());
    }
    aqhq.writeFile(BaseApplication.getContext().getFileStreamPath("DataReportConfigs").getAbsolutePath(), localJSONArray.toString());
  }
  
  public void disable()
  {
    this.mIsEnable = false;
    BaseApplicationImpl.getContext().unregisterReceiver(this.mBroadcastReceiver);
    hide();
    D(BaseApplicationImpl.getApplication(), false);
  }
  
  public void ec(ArrayList<afbe> paramArrayList)
  {
    int k = 0;
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.vV.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (afbe)((Iterator)localObject1).next();
      localHashMap.put(((afbe)localObject2).name, Boolean.valueOf(((afbe)localObject2).isChecked));
    }
    int i = 0;
    int j = k;
    if (i < this.vV.size())
    {
      localObject1 = (afbe)this.vV.get(i);
      j = i;
      if (!((afbe)localObject1).aiH())
      {
        this.vV.remove(i);
        i -= 1;
        if (!(localObject1 instanceof afbz)) {
          break label150;
        }
        this.mMap.remove(((afbz)localObject1).action);
        j = i;
      }
      label150:
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (!(localObject1 instanceof afca));
      localObject1 = ((afca)localObject1).vW.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (afbz)((Iterator)localObject1).next();
        this.mMap.remove(((afbz)localObject2).action);
      }
    }
    if (j < paramArrayList.size())
    {
      localObject1 = (afbe)paramArrayList.get(j);
      if (localHashMap.containsKey(((afbe)localObject1).name))
      {
        ((afbe)localObject1).isChecked = ((Boolean)localHashMap.get(((afbe)localObject1).name)).booleanValue();
        label265:
        if (!(localObject1 instanceof afbz)) {
          break label310;
        }
        this.mMap.put(((afbz)localObject1).action, (afbz)localObject1);
      }
      for (;;)
      {
        j += 1;
        break;
        ((afbe)localObject1).isChecked = true;
        break label265;
        label310:
        if ((localObject1 instanceof afca))
        {
          localObject1 = ((afca)localObject1).vW.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (afbz)((Iterator)localObject1).next();
            this.mMap.put(((afbz)localObject2).action, localObject2);
          }
        }
      }
    }
    this.vV.addAll(paramArrayList);
    cYr();
  }
  
  public void enable()
  {
    this.mIsEnable = true;
    IntentFilter localIntentFilter = new IntentFilter("action.data.report.viewer");
    BaseApplicationImpl.getContext().registerReceiver(this.mBroadcastReceiver, localIntentFilter);
    D(BaseApplicationImpl.getApplication(), true);
  }
  
  public void hide()
  {
    if (this.mIsAttached) {}
    try
    {
      this.mWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer);
      label20:
      this.mIsAttached = false;
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  public boolean isEnable()
  {
    return this.mIsEnable;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext();
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    if (i == 0) {
      this.cPZ = ((int)paramMotionEvent.getY());
    }
    label146:
    do
    {
      return false;
      if (i == 2)
      {
        if ((this.mIsDragging) || (Math.abs(paramMotionEvent.getY() - this.cPZ) > aqcx.dip2px(paramView, 10.0F)))
        {
          this.mIsDragging = true;
          paramMotionEvent = (WindowManager.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getLayoutParams();
          paramMotionEvent.y = (j - this.cPZ - riw.dip2px(paramView, 0.0F));
          i = this.mWindowManager.getDefaultDisplay().getHeight();
          if (paramMotionEvent.y >= 0) {
            break label146;
          }
          paramMotionEvent.y = 0;
        }
        for (;;)
        {
          this.mWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, paramMotionEvent);
          return true;
          if (paramMotionEvent.y > i - this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getHeight()) {
            paramMotionEvent.y = (i - this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getHeight());
          }
        }
      }
    } while ((i != 1) && (i != 3));
    return false;
  }
  
  public void show()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer == null)
    {
      this.mWindowManager = ((WindowManager)localBaseApplication.getSystemService("window"));
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer = new DataReportViewerFloatViewHelper.2(this, localBaseApplication, localBaseApplication);
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.setOnTouchListener(this);
    }
    if (!this.mIsAttached) {}
    try
    {
      this.mWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer);
      label67:
      int i;
      if (Build.VERSION.SDK_INT >= 26) {
        i = 2038;
      }
      for (;;)
      {
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
        localLayoutParams.gravity = 51;
        localLayoutParams.x = 0;
        localLayoutParams.y = aqcx.dip2px(localBaseApplication, 72.0F);
        try
        {
          this.mWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, localLayoutParams);
          this.mIsAttached = true;
          return;
          i = 2003;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QQToast.a(localBaseApplication, 1, acfp.m(2131704640), 0).show();
          }
        }
      }
    }
    catch (Exception localException2)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbx
 * JD-Core Version:    0.7.0.1
 */