import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.model.filter.FilterItem;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.3;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ync
  extends EditVideoFilter
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String i = anvx.a(2131703391);
  public static final String j = anvx.a(2131703209);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private wis<wkj> jdField_a_of_type_Wis = new ynd(this);
  private ywd jdField_a_of_type_Ywd;
  private SparseArray<yvr> b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 9 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "", jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString, jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, f, g, h, j };
    jdField_b_of_type_ArrayOfInt = new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 10 };
  }
  
  public ync(@NonNull ynw paramynw)
  {
    super(paramynw);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private yvr a(int paramInt1, @NonNull String paramString, int paramInt2, EditVideoParams.EditSource paramEditSource)
  {
    int k = this.jdField_b_of_type_AndroidUtilSparseArray.indexOfKey(paramInt1);
    yvr localyvr = (yvr)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (k >= 0)
    {
      paramString = (yvr)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(k);
      return paramString;
    }
    Object localObject = (ysa)wjs.a(8);
    localObject = localyvr;
    switch (paramInt1)
    {
    default: 
      localObject = localyvr;
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (paramInt1 == 7) {
        break;
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, localObject);
      return localObject;
      localObject = new ywb(paramString, paramInt2, 0, 0);
      continue;
      if (!(paramEditSource instanceof EditRecordVideoSource))
      {
        localObject = localyvr;
        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
      }
      else
      {
        localObject = new ywb(paramString, paramInt2, 0, 7);
        continue;
        if (!(paramEditSource instanceof EditRecordVideoSource))
        {
          localObject = localyvr;
          if (!(paramEditSource instanceof EditTakeVideoSource)) {}
        }
        else
        {
          localObject = new ywb(paramString, paramInt2, 0, 6);
          continue;
          if (!(paramEditSource instanceof EditRecordVideoSource))
          {
            localObject = localyvr;
            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
          }
          else
          {
            localObject = new ywb(paramString, paramInt2, 0, 5);
            continue;
            if (!(paramEditSource instanceof EditRecordVideoSource))
            {
              localObject = localyvr;
              if (!(paramEditSource instanceof EditTakeVideoSource)) {}
            }
            else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
            {
              localObject = null;
            }
            else
            {
              boolean bool = ((Boolean)((wjl)wjs.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
              if (((this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)) && (!bool))
              {
                ykq.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                localObject = null;
              }
              else
              {
                localObject = new ywb(paramString, paramInt2, 2130846532, 2);
                continue;
                localObject = localyvr;
                if (this.jdField_a_of_type_Yvt != null)
                {
                  localObject = new yvt(this.jdField_a_of_type_Yvt.a, paramString, paramInt2, this.jdField_a_of_type_Yvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Yvt.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Yvt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Yvt.f, this.jdField_a_of_type_Yvt.g, this.jdField_a_of_type_Yvt.h, this.jdField_a_of_type_Yvt.i, this.jdField_a_of_type_Yvt.jdField_c_of_type_Int, this.jdField_a_of_type_Yvt.jdField_d_of_type_Int, this.jdField_a_of_type_Yvt.jdField_e_of_type_Int);
                  continue;
                  if (!(paramEditSource instanceof EditRecordVideoSource))
                  {
                    localObject = localyvr;
                    if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                  }
                  else if (((this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)) && (!bbld.a))
                  {
                    ykq.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                    localObject = null;
                  }
                  else if ((this.jdField_a_of_type_Ynw.a.mBusinessId == 10) && (!this.jdField_a_of_type_Ynw.a.getEnableRevert()))
                  {
                    ykq.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe revert black model ! disable revert");
                    localObject = null;
                  }
                  else
                  {
                    localObject = new ywb(paramString, paramInt2, 2130846531, 1);
                    continue;
                    if (!(paramEditSource instanceof EditRecordVideoSource))
                    {
                      localObject = localyvr;
                      if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                    }
                    else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                    {
                      localObject = localyvr;
                      if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                    }
                    else
                    {
                      localObject = localyvr;
                      if (!"X9000".equalsIgnoreCase(Build.MODEL))
                      {
                        bool = ((Boolean)((wjl)wjs.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                        if (((this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)) && (!bool))
                        {
                          ykq.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                          localObject = null;
                        }
                        else if ((this.jdField_a_of_type_Ynw.a.mBusinessId == 10) && (!this.jdField_a_of_type_Ynw.a.getEnableSlow()))
                        {
                          ykq.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe slow black model ! disable slow");
                          localObject = null;
                        }
                        else
                        {
                          localObject = new ywb(paramString, paramInt2, 2130846533, 3);
                          continue;
                          localObject = new yvy(0, paramString, paramInt2);
                          continue;
                          if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                          {
                            localObject = localyvr;
                            if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                          }
                          else
                          {
                            if ((this.jdField_a_of_type_Yvt != null) && (b())) {
                              break label927;
                            }
                            if (this.jdField_a_of_type_Yvt == null) {
                              ykq.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : POI data is disable.");
                            }
                            localObject = localyvr;
                            if (!b())
                            {
                              ykq.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : has not open gps.");
                              localObject = localyvr;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label927:
    paramEditSource = (wkg)((wit)wjs.a(20)).a(0);
    localObject = paramEditSource.a();
    if (localObject != null)
    {
      ykq.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from cache.");
      this.jdField_a_of_type_Ywd = new ywd(0, paramString, paramInt2, ((wkj)localObject).a);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_Ywd;
      break;
      ykq.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from net.");
      this.jdField_a_of_type_Ywd = new ywd(0, paramString, paramInt2, 0);
      paramEditSource.a();
    }
  }
  
  private yvr a(@NonNull FilterItem paramFilterItem, EditVideoParams.EditSource paramEditSource)
  {
    switch (paramFilterItem.filterType)
    {
    case 8: 
    default: 
      return null;
    case 10: 
      paramEditSource = ((wkq)wjs.a(16)).a(paramFilterItem);
      if (paramEditSource != null) {
        return new yvv(0, paramFilterItem.filterName, (int)paramFilterItem.filterId, wkq.a(paramFilterItem), paramEditSource);
      }
      return null;
    }
    return a(paramFilterItem.filterType, paramFilterItem.filterName, (int)paramFilterItem.filterId, paramEditSource);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ykq.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress([lat]%d, [lng]%d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    wtg localwtg = new wtg(1, paramInt2, paramInt1);
    wfi.a().a(localwtg, new yne(this));
  }
  
  private boolean b()
  {
    return ((LocationManager)this.jdField_a_of_type_Ypg.a().getSystemService("location")).isProviderEnabled("gps");
  }
  
  public void a()
  {
    super.a();
    ((wkg)((wit)wjs.a(20)).a(0)).a(this.jdField_a_of_type_Wis);
  }
  
  public void a(int paramInt, win paramwin)
  {
    ykq.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onAddressRequestResult err=%d, address=%s, %s", Integer.valueOf(paramInt), paramwin, null);
    if (paramInt == 0)
    {
      Activity localActivity = this.jdField_a_of_type_Ypg.getActivity();
      if (localActivity != null) {
        localActivity.runOnUiThread(new EditVideoFilterNeo.3(this, paramwin));
      }
    }
    else
    {
      return;
    }
    ykq.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "activity is Null! can't boardcast AddressInforamtion");
  }
  
  public void d()
  {
    ((wkg)((wit)wjs.a(20)).a(0)).b(this.jdField_a_of_type_Wis);
    super.d();
  }
  
  public void g()
  {
    EditVideoParams localEditVideoParams = this.jdField_a_of_type_Ynw.a;
    int m;
    label48:
    LocalMediaInfo localLocalMediaInfo;
    if (localEditVideoParams.getBussinessId() == 1)
    {
      k = 1;
      if ((k == 0) || ((!(localEditVideoParams.mEditSource instanceof EditLocalPhotoSource)) && (!(localEditVideoParams.mEditSource instanceof EditLocalVideoSource)))) {
        break label127;
      }
      m = 1;
      if ((k == 0) || (m == 0)) {
        break label158;
      }
      localLocalMediaInfo = null;
      if (!(localEditVideoParams.mEditSource instanceof EditLocalPhotoSource)) {
        break label132;
      }
      localLocalMediaInfo = ((EditLocalPhotoSource)localEditVideoParams.mEditSource).a;
      label81:
      if ((localLocalMediaInfo == null) || ((localLocalMediaInfo.latitude == 0) && (localLocalMediaInfo.longitude == 0))) {
        break label158;
      }
      a(localLocalMediaInfo.latitude, localLocalMediaInfo.longitude);
    }
    label132:
    label158:
    for (int k = 1;; k = 0)
    {
      if (k == 0) {
        super.g();
      }
      return;
      k = 0;
      break;
      label127:
      m = 0;
      break label48;
      if (!(localEditVideoParams.mEditSource instanceof EditLocalVideoSource)) {
        break label81;
      }
      localLocalMediaInfo = ((EditLocalVideoSource)localEditVideoParams.mEditSource).a;
      break label81;
    }
  }
  
  public void h()
  {
    Object localObject1 = ((wkq)wjs.a(16)).a();
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject1).isEmpty())
    {
      int k = 0;
      while (k < jdField_a_of_type_ArrayOfInt.length)
      {
        localObject1 = a(jdField_a_of_type_ArrayOfInt[k], jdField_a_of_type_ArrayOfJavaLangString[k], jdField_b_of_type_ArrayOfInt[k], this.jdField_a_of_type_Ynw.a.mEditSource);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        k += 1;
      }
    }
    Object localObject2 = a(-1, "", -1, this.jdField_a_of_type_Ynw.a.mEditSource);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterItem)((Iterator)localObject1).next();
      yvr localyvr = a((FilterItem)localObject2, this.jdField_a_of_type_Ynw.a.mEditSource);
      if (localyvr != null)
      {
        ykq.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "Filter : %s", new Object[] { localObject2 });
        localArrayList.add(localyvr);
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ync
 * JD-Core Version:    0.7.0.1
 */