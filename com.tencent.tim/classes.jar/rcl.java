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

public class rcl
  extends EditVideoFilter
{
  public static final String azK = acfp.m(2131705687);
  public static final String azL = acfp.m(2131705501);
  public static final String[] bY = { "", azC, azD, azE, azF, azG, azH, azI, azJ, azL };
  public static final int[] dX = { -1, 0, 1, 2, 3, 4, 5, 6, 7, 9 };
  public static final int[] dY = { -1, 1, 2, 3, 4, 5, 6, 7, 8, 10 };
  private psc.a<pth.a> jdField_a_of_type_Psc$a = new rcm(this);
  private rjh jdField_a_of_type_Rjh;
  private SparseArray<rja> aV = new SparseArray();
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  public rcl(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  private boolean KX()
  {
    return ((LocationManager)this.jdField_a_of_type_Rel.getContext().getSystemService("location")).isProviderEnabled("gps");
  }
  
  private rja a(int paramInt1, @NonNull String paramString, int paramInt2, EditVideoParams.EditSource paramEditSource)
  {
    int i = this.aV.indexOfKey(paramInt1);
    rja localrja = (rja)this.aV.get(paramInt1);
    if (i >= 0)
    {
      paramString = (rja)this.aV.valueAt(i);
      return paramString;
    }
    Object localObject = (rgp)psx.a(8);
    localObject = localrja;
    switch (paramInt1)
    {
    default: 
      localObject = localrja;
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (paramInt1 == 7) {
        break;
      }
      this.aV.put(paramInt1, localObject);
      return localObject;
      localObject = new rjg(paramString, paramInt2, 0, 0);
      continue;
      if (!(paramEditSource instanceof EditRecordVideoSource))
      {
        localObject = localrja;
        if (!(paramEditSource instanceof EditTakeVideoSource)) {}
      }
      else
      {
        localObject = new rjg(paramString, paramInt2, 0, 7);
        continue;
        if (!(paramEditSource instanceof EditRecordVideoSource))
        {
          localObject = localrja;
          if (!(paramEditSource instanceof EditTakeVideoSource)) {}
        }
        else
        {
          localObject = new rjg(paramString, paramInt2, 0, 6);
          continue;
          if (!(paramEditSource instanceof EditRecordVideoSource))
          {
            localObject = localrja;
            if (!(paramEditSource instanceof EditTakeVideoSource)) {}
          }
          else
          {
            localObject = new rjg(paramString, paramInt2, 0, 5);
            continue;
            if (!(paramEditSource instanceof EditRecordVideoSource))
            {
              localObject = localrja;
              if (!(paramEditSource instanceof EditTakeVideoSource)) {}
            }
            else if (((paramEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
            {
              localObject = null;
            }
            else
            {
              boolean bool = ((Boolean)((psr)psx.a(10)).c("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
              if (((this.b.a.a instanceof EditTakeVideoSource)) && (!bool))
              {
                ram.w("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                localObject = null;
              }
              else
              {
                localObject = new rjg(paramString, paramInt2, 2130847393, 2);
                continue;
                localObject = localrja;
                if (this.jdField_a_of_type_Rjb != null)
                {
                  localObject = new rjb(this.jdField_a_of_type_Rjb.bsq, paramString, paramInt2, this.jdField_a_of_type_Rjb.awA, this.jdField_a_of_type_Rjb.awB, this.jdField_a_of_type_Rjb.country, this.jdField_a_of_type_Rjb.city, this.jdField_a_of_type_Rjb.province, this.jdField_a_of_type_Rjb.street, this.jdField_a_of_type_Rjb.building, this.jdField_a_of_type_Rjb.longitude, this.jdField_a_of_type_Rjb.latitude, this.jdField_a_of_type_Rjb.coordinate);
                  continue;
                  if (!(paramEditSource instanceof EditRecordVideoSource))
                  {
                    localObject = localrja;
                    if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                  }
                  else if (((this.b.a.a instanceof EditTakeVideoSource)) && (!alzf.cBz))
                  {
                    ram.w("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                    localObject = null;
                  }
                  else if ((this.b.a.asi == 10) && (!this.b.a.Lh()))
                  {
                    ram.w("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe revert black model ! disable revert");
                    localObject = null;
                  }
                  else
                  {
                    localObject = new rjg(paramString, paramInt2, 2130847392, 1);
                    continue;
                    if (!(paramEditSource instanceof EditRecordVideoSource))
                    {
                      localObject = localrja;
                      if (!(paramEditSource instanceof EditTakeVideoSource)) {}
                    }
                    else if ("Meizu".equalsIgnoreCase(Build.MANUFACTURER))
                    {
                      localObject = localrja;
                      if ("MX4 Pro".equalsIgnoreCase(Build.MODEL)) {}
                    }
                    else
                    {
                      localObject = localrja;
                      if (!"X9000".equalsIgnoreCase(Build.MODEL))
                      {
                        bool = ((Boolean)((psr)psx.a(10)).c("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
                        if (((this.b.a.a instanceof EditTakeVideoSource)) && (!bool))
                        {
                          ram.w("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
                          localObject = null;
                        }
                        else if ((this.b.a.asi == 10) && (!this.b.a.Li()))
                        {
                          ram.w("Q.qqstory.publish.edit.EditVideoFilterNeo", "it's tribe slow black model ! disable slow");
                          localObject = null;
                        }
                        else
                        {
                          localObject = new rjg(paramString, paramInt2, 2130847394, 3);
                          continue;
                          localObject = new rje(0, paramString, paramInt2);
                          continue;
                          if ((!(paramEditSource instanceof EditRecordVideoSource)) && (!(paramEditSource instanceof EditTakeVideoSource)))
                          {
                            localObject = localrja;
                            if (!(paramEditSource instanceof EditTakePhotoSource)) {}
                          }
                          else
                          {
                            if ((this.jdField_a_of_type_Rjb != null) && (KX())) {
                              break label937;
                            }
                            if (this.jdField_a_of_type_Rjb == null) {
                              ram.w("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : POI data is disable.");
                            }
                            localObject = localrja;
                            if (!KX())
                            {
                              ram.w("Q.qqstory.publish.edit.EditVideoFilterNeo", "TYPE_TEMP : has not open gps.");
                              localObject = localrja;
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
    label937:
    paramEditSource = (pth)((psd)psx.a(20)).a(0);
    localObject = paramEditSource.a();
    if (localObject != null)
    {
      ram.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from cache.");
      this.jdField_a_of_type_Rjh = new rjh(0, paramString, paramInt2, ((pth.a)localObject).temperature);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_Rjh;
      break;
      ram.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "get weather from net.");
      this.jdField_a_of_type_Rjh = new rjh(0, paramString, paramInt2, 0);
      paramEditSource.biW();
    }
  }
  
  private rja a(@NonNull FilterItem paramFilterItem, EditVideoParams.EditSource paramEditSource)
  {
    switch (paramFilterItem.filterType)
    {
    case 8: 
    default: 
      return null;
    case 10: 
      paramEditSource = ((ptn)psx.a(16)).a(paramFilterItem);
      if (paramEditSource != null) {
        return new rjc(0, paramFilterItem.filterName, (int)paramFilterItem.filterId, ptn.a(paramFilterItem), paramEditSource);
      }
      return null;
    }
    return a(paramFilterItem.filterType, paramFilterItem.filterName, (int)paramFilterItem.filterId, paramEditSource);
  }
  
  private void dO(int paramInt1, int paramInt2)
  {
    ram.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "requestAddress([lat]%d, [lng]%d)", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    pyx localpyx = new pyx(1, paramInt2, paramInt1);
    ppv.a().a(localpyx, new rcn(this));
  }
  
  public void a(int paramInt, prw.a parama)
  {
    ram.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onAddressRequestResult err=%d, address=%s, %s", Integer.valueOf(paramInt), parama, null);
    if (paramInt == 0)
    {
      Activity localActivity = this.jdField_a_of_type_Rel.getActivity();
      if (localActivity != null) {
        localActivity.runOnUiThread(new EditVideoFilterNeo.3(this, parama));
      }
    }
    else
    {
      return;
    }
    ram.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "activity is Null! can't boardcast AddressInforamtion");
  }
  
  public void bsJ()
  {
    EditVideoParams localEditVideoParams = this.b.a;
    int j;
    label48:
    LocalMediaInfo localLocalMediaInfo;
    if (localEditVideoParams.tg() == 1)
    {
      i = 1;
      if ((i == 0) || ((!(localEditVideoParams.a instanceof EditLocalPhotoSource)) && (!(localEditVideoParams.a instanceof EditLocalVideoSource)))) {
        break label127;
      }
      j = 1;
      if ((i == 0) || (j == 0)) {
        break label158;
      }
      localLocalMediaInfo = null;
      if (!(localEditVideoParams.a instanceof EditLocalPhotoSource)) {
        break label132;
      }
      localLocalMediaInfo = ((EditLocalPhotoSource)localEditVideoParams.a).d;
      label81:
      if ((localLocalMediaInfo == null) || ((localLocalMediaInfo.latitude == 0) && (localLocalMediaInfo.longitude == 0))) {
        break label158;
      }
      dO(localLocalMediaInfo.latitude, localLocalMediaInfo.longitude);
    }
    label132:
    label158:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.bsJ();
      }
      return;
      i = 0;
      break;
      label127:
      j = 0;
      break label48;
      if (!(localEditVideoParams.a instanceof EditLocalVideoSource)) {
        break label81;
      }
      localLocalMediaInfo = ((EditLocalVideoSource)localEditVideoParams.a).d;
      break label81;
    }
  }
  
  public void bsK()
  {
    Object localObject1 = ((ptn)psx.a(16)).bM();
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject1).isEmpty())
    {
      int i = 0;
      while (i < dX.length)
      {
        localObject1 = a(dX[i], bY[i], dY[i], this.b.a.a);
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject2 = a(-1, "", -1, this.b.a.a);
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterItem)((Iterator)localObject1).next();
      rja localrja = a((FilterItem)localObject2, this.b.a.a);
      if (localrja != null)
      {
        ram.w("Q.qqstory.publish.edit.EditVideoFilterNeo", "Filter : %s", new Object[] { localObject2 });
        localArrayList.add(localrja);
      }
    }
    this.BJ = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.eM(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
  }
  
  public void onCreate()
  {
    super.onCreate();
    ((pth)((psd)psx.a(20)).a(0)).a(this.jdField_a_of_type_Psc$a);
  }
  
  public void onDestroy()
  {
    ((pth)((psd)psx.a(20)).a(0)).b(this.jdField_a_of_type_Psc$a);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcl
 * JD-Core Version:    0.7.0.1
 */