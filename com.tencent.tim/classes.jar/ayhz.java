import android.os.Build;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewStub;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.1;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer.a;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ayhz
  extends EditVideoFilter
  implements PickerContainer.a
{
  private static String cWP = "EditVideoSpeedFilter";
  public PickerContainer a;
  boolean dzk = false;
  private boolean dzl;
  private int eKj = 1;
  private boolean mEnable;
  private ViewStub y;
  
  public ayhz(@NonNull aygz paramaygz, boolean paramBoolean)
  {
    super(paramaygz);
    this.mEnable = paramBoolean;
    if (this.mEnable) {
      this.mEnable = aQE();
    }
    ram.d("Q.qqstory.publish.editEditVideoSpeedFilter", "EditVideoSpeedFilter : enable: " + this.mEnable);
  }
  
  private void Zp(boolean paramBoolean)
  {
    if (this.eKj == 2) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer == null);
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 4) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 8));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.setVisibility(4);
  }
  
  private boolean aQE()
  {
    boolean bool1;
    psr localpsr;
    if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
    {
      bool1 = true;
      if (!bool1) {
        ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's Meizu MX4 Pro, in backlist");
      }
      localpsr = (psr)psx.a(10);
      if (localpsr != null) {
        break label62;
      }
      ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "storyConfigManager == null !!!");
    }
    label62:
    boolean bool2;
    do
    {
      return bool1;
      bool1 = false;
      break;
      bool2 = bool1;
      if (bool1)
      {
        bool1 = ((Boolean)localpsr.c("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
        bool2 = bool1;
        if (!bool1)
        {
          ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
          bool2 = bool1;
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        bool2 = ((Boolean)localpsr.c("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
        bool1 = bool2;
        if (!bool2)
        {
          ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
          bool1 = bool2;
        }
      }
      if (!bool1) {
        return bool1;
      }
      bool2 = ((Boolean)localpsr.c("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
      bool1 = bool2;
    } while (bool2);
    ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
    return bool2;
    return bool1;
  }
  
  private void eK(int paramInt, String paramString)
  {
    int k = 0;
    ram.d("Q.qqstory.publish.editEditVideoSpeedFilter", "onPlayModeChanged:" + paramInt + "  " + paramString);
    List localList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.oA;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < localList.size())
      {
        ayoq localayoq = (ayoq)localList.get(i);
        if ((!TextUtils.isEmpty(localayoq.aAH)) && (localayoq.bsq == paramInt))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(i, false);
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          QQToast.a(getContext(), acfp.m(2131705594) + paramString, 1000).show();
        }
        return;
      }
      i += 1;
    }
  }
  
  private void eRQ()
  {
    ThreadManager.getUIHandler().postDelayed(new EditVideoSpeedFilter.1(this), 500L);
  }
  
  private int lX(int paramInt)
  {
    int i = 2;
    ram.d("Q.qqstory.publish.editEditVideoSpeedFilter", "transSpecialPlayMode : nSpeedIndex = " + paramInt);
    if (rma.a().tG() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, 13);
    }
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    case 4: 
    case 3: 
    case 2: 
    case 1: 
    case 0: 
      do
      {
        return paramInt;
        if (rma.a().tG() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 5);
        }
        return 9;
        if (rma.a().tG() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 4);
        }
        return 3;
        if (rma.a().tG() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 1);
        }
        return 0;
        if (rma.a().tG() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 2);
        }
        return 8;
        paramInt = i;
      } while (rma.a().tG() != 22);
      LpReportInfo_pf00064.allReport(680, 10, 3);
      return 2;
    }
    if (rma.a().tG() == 22) {
      LpReportInfo_pf00064.allReport(680, 10, 6);
    }
    return 1;
  }
  
  private int lY(int paramInt)
  {
    ram.d("Q.qqstory.publish.editEditVideoSpeedFilter", "transSpecialPlayMode : nPlayMode = " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 2;
    case 9: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 0;
    case 8: 
      return 1;
    }
    return 5;
  }
  
  public void bsK()
  {
    ram.b("Q.qqstory.publish.editEditVideoSpeedFilter", "updateFilterMode : %s", this.b.a.a);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (((this.b.a.a instanceof EditRecordVideoSource)) || ((this.b.a.a instanceof EditTakeVideoSource)) || ((this.b.a.a instanceof EditLocalVideoSource)))
    {
      localObject = (psr)psx.a(10);
      localArrayList.add(new ayou(cWU, -1, 0, 0));
      if (((Boolean)((psr)localObject).c("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue()) {
        break label316;
      }
      ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
      {
        if (((Boolean)((psr)localObject).c("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue()) {
          break label361;
        }
        ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
      label209:
      if (!(this.b.a.a instanceof EditLocalVideoSource))
      {
        if (((Boolean)((psr)localObject).c("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue()) {
          break label489;
        }
        ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
    }
    label267:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.eM(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
    this.BJ = System.currentTimeMillis();
    if (localArrayList.isEmpty()) {}
    for (int i = 0;; i = ((ayoq)localArrayList.get(0)).bsq)
    {
      this.bpX = i;
      return;
      label316:
      localArrayList.add(new ayou(azC, 1, 0, 2));
      localArrayList.add(new ayou(cWV, 9, 0, 8));
      break;
      label361:
      if ((this.b.a.asi == 11) && (!this.b.a.Li()))
      {
        ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's tribe slow black model, disable slow!");
        break label209;
      }
      if ((this.b.a.asi == 12) && (!this.b.a.Li()))
      {
        ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's readinjoy slow black model, disable slow!");
        break label209;
      }
      localArrayList.add(new ayou(azD, 2, 0, 3));
      localArrayList.add(new ayou(cWW, 10, 0, 9));
      this.dzk = true;
      break label209;
      label489:
      if ((this.b.a.asi == 11) && (!this.b.a.Lh()))
      {
        ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's tribe revert black model, disable revert!");
        break label267;
      }
      if ((this.b.a.asi == 12) && (!this.b.a.Lh()))
      {
        ram.w("Q.qqstory.publish.editEditVideoSpeedFilter", "it's tribe readinjoy black model, disable revert!");
        break label267;
      }
      ayou localayou = new ayou(azE, 3, 0, 1);
      if (this.b.a.Lg()) {}
      for (localObject = acfp.m(2131705656);; localObject = null)
      {
        localayou.aAI = ((String)localObject);
        localArrayList.add(localayou);
        break;
      }
    }
  }
  
  public void cm(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      ayoq localayoq = a();
      if (localayoq == null) {
        return;
      }
      int i = localayoq.bsq;
      if (i != 0)
      {
        localJSONObject.put("playMode", i);
        localJSONObject.put("filterName", localayoq.aAH);
        localJSONObject.put("filterId", localayoq.bsr);
        localJSONObject.put("hintWording", localayoq.aAI);
      }
      paramJSONObject.put(cWP, localJSONObject);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public boolean e(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    if (this.mEnable) {
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      bool1 = super.e(paramMessage);
      do
      {
        return bool1;
        this.eKj = paramMessage.arg1;
        int i = paramMessage.arg2;
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer == null);
      paramMessage = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer;
      if (this.eKj != 1)
      {
        bool1 = bool2;
        if (this.eKj != 3) {}
      }
      else
      {
        bool1 = true;
      }
      paramMessage.U(bool1, this.BK);
      return true;
      Zp(false);
      continue;
      Zp(true);
    }
  }
  
  public void eL(int paramInt, String paramString)
  {
    ram.d("Q.qqstory.publish.editEditVideoSpeedFilter", "onPickSpeedStart:" + paramInt + "  " + paramString);
    this.dzl = true;
  }
  
  public void eM(int paramInt, String paramString)
  {
    ram.d("Q.qqstory.publish.editEditVideoSpeedFilter", "onPickSpeed:" + paramInt + "  " + paramString + " moving:" + this.dzl);
    if (this.dzl) {
      return;
    }
    eK(lX(paramInt), paramString);
    paramString = this.b.a(ayeg.class);
    if ((paramString instanceof ayeg)) {
      ((ayeg)paramString).eQN();
    }
    this.b.a(Message.obtain(null, 9, 28, paramInt));
  }
  
  public void eN(int paramInt, String paramString)
  {
    ram.d("Q.qqstory.publish.editEditVideoSpeedFilter", "onSpeedPickEnd:" + paramInt + "  " + paramString);
    eK(lX(paramInt), paramString);
    this.dzl = false;
  }
  
  public void eRz() {}
  
  public void onCreate()
  {
    super.onCreate();
    eRQ();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.y = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.unInit();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = null;
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    super.p(paramInt, paramObject);
    if (!this.mEnable) {
      return;
    }
    switch (paramInt)
    {
    default: 
      Zp(true);
      return;
    case 28: 
      paramInt = lY(this.bpX);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.cE(paramInt, false);
      }
      Zp(true);
      return;
    }
    Zp(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhz
 * JD-Core Version:    0.7.0.1
 */