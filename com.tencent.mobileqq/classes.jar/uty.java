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

public class uty
  extends EditVideoFilter
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String i = ajjy.a(2131638125);
  public static final String j = ajjy.a(2131637939);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private spg<sqx> jdField_a_of_type_Spg = new utz(this);
  private vdk jdField_a_of_type_Vdk;
  private SparseArray<vcy> b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 9 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "", jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString, jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, f, g, h, j };
    jdField_b_of_type_ArrayOfInt = new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 10 };
  }
  
  public uty(@NonNull uut paramuut)
  {
    super(paramuut);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private vcy a(int paramInt1, @NonNull String paramString, int paramInt2, EditVideoParams.EditSource paramEditSource)
  {
    int k = this.jdField_b_of_type_AndroidUtilSparseArray.indexOfKey(paramInt1);
    vcy localvcy = (vcy)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (k >= 0)
    {
      paramString = (vcy)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(k);
      return paramString;
    }
    Object localObject = (uyz)sqg.a(8);
    localObject = localvcy;
    switch (paramInt1)
    {
    default: 
      localObject = localvcy;
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (paramInt1 == 7) {
        break;
      }
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt1, localObject);
      return localObject;
      localObject = new vdi(paramString, paramInt2, 0, 0);
      continue;
      if (!(paramEditSource instanceof EditRecordVideoSource))
      {
        localObject = localvcy;
        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
      }
      else
      {
        localObject = new vdi(paramString, paramInt2, 0, 7);
        continue;
        if (!(paramEditSource instanceof EditRecordVideoSource))
        {
          localObject = localvcy;
          if (!(paramEditSource instanceof EditTakeVideoSource)) {}
        }
        else
        {
          localObject = new vdi(paramString, paramInt2, 0, 6);
          continue;
          if (!(paramEditSource instanceof EditRecordVideoSource))
          {
            localObject = localvcy;
            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
          }
          else
          {
            localObject = new vdi(paramString, paramInt2, 0, 5);
            continue;
            if (!(paramEditSource instanceof EditRecordVideoSource))
            {
              localObject = localvcy;
              if (!(paramEditSource instanceof EditTakeVideoSource)) {}
            }
            else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
            {
              localObject = null;
            }
            else
            {
              boolean bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
              if (((this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!bool))
              {
                urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                localObject = null;
              }
              else
              {
                localObject = new vdi(paramString, paramInt2, 2130845430, 2);
                continue;
                localObject = localvcy;
                if (this.jdField_a_of_type_Vda != null)
                {
                  localObject = new vda(this.jdField_a_of_type_Vda.jdField_a_of_type_Int, paramString, paramInt2, this.jdField_a_of_type_Vda.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Vda.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Vda.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Vda.f, this.jdField_a_of_type_Vda.g, this.jdField_a_of_type_Vda.h, this.jdField_a_of_type_Vda.i, this.jdField_a_of_type_Vda.jdField_c_of_type_Int, this.jdField_a_of_type_Vda.jdField_d_of_type_Int, this.jdField_a_of_type_Vda.jdField_e_of_type_Int);
                  continue;
                  if (!(paramEditSource instanceof EditRecordVideoSource))
                  {
                    localObject = localvcy;
                    if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                  }
                  else if (((this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!auxw.a))
                  {
                    urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                    localObject = null;
                  }
                  else if ((this.jdField_a_of_type_Uut.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Uut.a.h()))
                  {
                    urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe revert black model ! disable revert");
                    localObject = null;
                  }
                  else
                  {
                    localObject = new vdi(paramString, paramInt2, 2130845429, 1);
                    continue;
                    if (!(paramEditSource instanceof EditRecordVideoSource))
                    {
                      localObject = localvcy;
                      if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                    }
                    else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                    {
                      localObject = localvcy;
                      if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                    }
                    else
                    {
                      localObject = localvcy;
                      if (!"X9000".equalsIgnoreCase(Build.MODEL))
                      {
                        bool = ((Boolean)((spz)sqg.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                        if (((this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!bool))
                        {
                          urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                          localObject = null;
                        }
                        else if ((this.jdField_a_of_type_Uut.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Uut.a.i()))
                        {
                          urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe slow black model ! disable slow");
                          localObject = null;
                        }
                        else
                        {
                          localObject = new vdi(paramString, paramInt2, 2130845431, 3);
                          continue;
                          localObject = new vdf(0, paramString, paramInt2);
                          continue;
                          if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                          {
                            localObject = localvcy;
                            if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                          }
                          else
                          {
                            if ((this.jdField_a_of_type_Vda != null) && (b())) {
                              break label926;
                            }
                            if (this.jdField_a_of_type_Vda == null) {
                              urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : POI data is disable.");
                            }
                            localObject = localvcy;
                            if (!b())
                            {
                              urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : has not open gps.");
                              localObject = localvcy;
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
    label926:
    paramEditSource = (squ)((sph)sqg.a(20)).a(0);
    localObject = paramEditSource.a();
    if (localObject != null)
    {
      urk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from cache.");
      this.jdField_a_of_type_Vdk = new vdk(0, paramString, paramInt2, ((sqx)localObject).jdField_a_of_type_Int);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_Vdk;
      break;
      urk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from net.");
      this.jdField_a_of_type_Vdk = new vdk(0, paramString, paramInt2, 0);
      paramEditSource.a();
    }
  }
  
  private vcy a(@NonNull FilterItem paramFilterItem, EditVideoParams.EditSource paramEditSource)
  {
    switch (paramFilterItem.filterType)
    {
    case 8: 
    default: 
      return null;
    case 10: 
      paramEditSource = ((sre)sqg.a(16)).a(paramFilterItem);
      if (paramEditSource != null) {
        return new vdc(0, paramFilterItem.filterName, (int)paramFilterItem.filterId, sre.a(paramFilterItem), paramEditSource);
      }
      return null;
    }
    return a(paramFilterItem.filterType, paramFilterItem.filterName, (int)paramFilterItem.filterId, paramEditSource);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    urk.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress([lat]%d, [lng]%d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    szu localszu = new szu(1, paramInt2, paramInt1);
    slv.a().a(localszu, new uua(this));
  }
  
  private boolean b()
  {
    return ((LocationManager)this.jdField_a_of_type_Uwe.a().getSystemService("location")).isProviderEnabled("gps");
  }
  
  public void a()
  {
    super.a();
    ((squ)((sph)sqg.a(20)).a(0)).a(this.jdField_a_of_type_Spg);
  }
  
  public void a(int paramInt, spb paramspb)
  {
    urk.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onAddressRequestResult err=%d, address=%s, %s", Integer.valueOf(paramInt), paramspb, null);
    if (paramInt == 0)
    {
      Activity localActivity = this.jdField_a_of_type_Uwe.getActivity();
      if (localActivity != null) {
        localActivity.runOnUiThread(new EditVideoFilterNeo.3(this, paramspb));
      }
    }
    else
    {
      return;
    }
    urk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "activity is Null! can't boardcast AddressInforamtion");
  }
  
  public void d()
  {
    ((squ)((sph)sqg.a(20)).a(0)).b(this.jdField_a_of_type_Spg);
    super.d();
  }
  
  public void f()
  {
    EditVideoParams localEditVideoParams = this.jdField_a_of_type_Uut.a;
    int m;
    label48:
    LocalMediaInfo localLocalMediaInfo;
    if (localEditVideoParams.a() == 1)
    {
      k = 1;
      if ((k == 0) || ((!(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) && (!(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))) {
        break label127;
      }
      m = 1;
      if ((k == 0) || (m == 0)) {
        break label158;
      }
      localLocalMediaInfo = null;
      if (!(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        break label132;
      }
      localLocalMediaInfo = ((EditLocalPhotoSource)localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a;
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
        super.f();
      }
      return;
      k = 0;
      break;
      label127:
      m = 0;
      break label48;
      if (!(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        break label81;
      }
      localLocalMediaInfo = ((EditLocalVideoSource)localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).a;
      break label81;
    }
  }
  
  public void g()
  {
    Object localObject1 = ((sre)sqg.a(16)).a();
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject1).isEmpty())
    {
      int k = 0;
      while (k < jdField_a_of_type_ArrayOfInt.length)
      {
        localObject1 = a(jdField_a_of_type_ArrayOfInt[k], jdField_a_of_type_ArrayOfJavaLangString[k], jdField_b_of_type_ArrayOfInt[k], this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        k += 1;
      }
    }
    Object localObject2 = a(-1, "", -1, this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterItem)((Iterator)localObject1).next();
      vcy localvcy = a((FilterItem)localObject2, this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      if (localvcy != null)
      {
        urk.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "Filter : %s", new Object[] { localObject2 });
        localArrayList.add(localvcy);
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uty
 * JD-Core Version:    0.7.0.1
 */