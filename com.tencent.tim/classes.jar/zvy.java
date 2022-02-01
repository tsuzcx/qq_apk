import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicWeiyun.1;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zvy
  extends ztv
{
  private boolean bud;
  
  zvy(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public List<LocalMediaInfo> getLocalMediaInfos()
  {
    int i = 0;
    Object localObject2 = (NewPhotoListActivity)this.mActivity;
    if ((localObject2 == null) || (((NewPhotoListActivity)localObject2).isFinishing()))
    {
      aqip.endPile("PEAK", "getAlbumMedias");
      return null;
    }
    Object localObject1 = awrd.u(((NewPhotoListActivity)localObject2).getApplicationContext(), this.mPhotoCommonData.myUin, "pref_select_album");
    List localList;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localList = awrd.h((String)localObject1);
      if ((localList != null) && (!localList.isEmpty()) && (!TextUtils.equals((CharSequence)localList.get(0), "$RecentAlbumId")))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(localList.get(0));
      }
    }
    for (;;)
    {
      localList = aqfy.a((Context)localObject2, 1000, (List)localObject1, this.a.filter);
      aqip.endPile("PEAK", "getAlbumMedias");
      if (localList == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
        return null;
      }
      int j;
      if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() != 0)) {
        if (i < this.mPhotoCommonData.selectedPhotoList.size())
        {
          localObject1 = (String)this.mPhotoCommonData.selectedPhotoList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
            j = i;
          }
          for (;;)
          {
            i = j + 1;
            break;
            j = i;
            if (!new File((String)localObject1).exists()) {
              if ((((String)localObject1).startsWith("http")) && (((zuc)this.mOtherCommonData).selectedQzonePhotos != null))
              {
                j = i;
                if (((zuc)this.mOtherCommonData).selectedQzonePhotos.containsKey(localObject1)) {}
              }
              else
              {
                this.mPhotoCommonData.selectedPhotoList.remove(i);
                i -= 1;
                j = i;
                if (this.mPhotoCommonData.needMediaInfo)
                {
                  j = i;
                  if (this.mPhotoCommonData.selectedMediaInfoHashMap != null)
                  {
                    j = i;
                    if (this.mPhotoCommonData.selectedMediaInfoHashMap.containsKey(localObject1))
                    {
                      this.mPhotoCommonData.selectedMediaInfoHashMap.remove(localObject1);
                      j = i;
                    }
                  }
                }
              }
            }
          }
        }
      }
      i = localList.size();
      localObject2 = ((NewPhotoListActivity)localObject2).getIntent().getStringArrayListExtra("weiyun_filter_data");
      if (localObject2 != null)
      {
        i -= 1;
        if (i >= 0)
        {
          localObject1 = (LocalMediaInfo)localList.get(i);
          j = ((LocalMediaInfo)localObject1).path.lastIndexOf("/");
          String str = ((LocalMediaInfo)localObject1).path.substring(j + 1);
          File localFile = new File(((LocalMediaInfo)localObject1).path);
          if (localFile.exists()) {}
          for (localObject1 = str + localFile.length();; localObject1 = str + ((LocalMediaInfo)localObject1).fileSize)
          {
            if (((ArrayList)localObject2).contains(localObject1)) {
              localList.remove(i);
            }
            i -= 1;
            break;
          }
        }
      }
      return localList;
      localObject1 = null;
    }
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    Object localObject = (NewPhotoListActivity)this.mActivity;
    if ((localObject == null) || (((NewPhotoListActivity)localObject).isFinishing())) {
      return;
    }
    this.mPhotoCommonData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    localObject = awrd.u(((NewPhotoListActivity)localObject).getApplicationContext(), this.mPhotoCommonData.myUin, "pref_select_album");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = awrd.h((String)localObject);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        this.mPhotoCommonData.albumId = ((String)((List)localObject).get(0));
      }
    }
    this.a.isRecodeLastAlbumPath = false;
    this.bud = paramIntent.getBooleanExtra("PhotoConst.ENTER_ALBUM_LIST", false);
  }
  
  public boolean needVedio()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    ArrayList localArrayList;
    if ((localNewPhotoListActivity != null) && (!localNewPhotoListActivity.isFinishing()) && (paramInt1 == 100010))
    {
      if (paramInt2 != -1) {
        break label114;
      }
      Intent localIntent = new Intent();
      if (this.mPhotoCommonData.selectedPhotoList != null) {
        break label102;
      }
      localArrayList = new ArrayList(0);
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      localNewPhotoListActivity.setResult(-1, localIntent);
      localNewPhotoListActivity.finish();
      aqfy.anim(localNewPhotoListActivity, false, false);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label102:
      localArrayList = this.mPhotoCommonData.selectedPhotoList;
      break;
      label114:
      updateButton();
      localNewPhotoListActivity.runOnUiThread(new PhotoListLogicWeiyun.1(this, localNewPhotoListActivity));
    }
  }
  
  public void onAlbumListShown(boolean paramBoolean)
  {
    if ((this.bud) && (!paramBoolean)) {
      onTitleBtnCancelClick(null);
    }
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if ((localNewPhotoListActivity != null) && (!localNewPhotoListActivity.isFinishing())) {
      localNewPhotoListActivity.setResult(-1, new Intent());
    }
    super.onTitleBtnCancelClick(paramView);
  }
  
  public void postInitUI()
  {
    super.postInitUI();
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {}
    do
    {
      return;
      View localView = localNewPhotoListActivity.findViewById(2131369579);
      if (localView != null) {
        localView.setContentDescription(localNewPhotoListActivity.getString(2131721945));
      }
    } while (!this.bud);
    enterAlbumListFragment(localNewPhotoListActivity.getIntent());
    localNewPhotoListActivity.transAlbumList(true);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {
      return;
    }
    localNewPhotoListActivity.startActivityForResult(paramIntent, 100010);
  }
  
  protected void submit()
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.mActivity;
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {
      return;
    }
    Intent localIntent;
    if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId"))
    {
      anpc.a(localNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      if (this.mPhotoCommonData.selectedPhotoList != null)
      {
        zsz.j(localNewPhotoListActivity.getIntent(), this.mPhotoCommonData.selectedPhotoList.size());
        zsz.d(localNewPhotoListActivity.getIntent(), this.mPhotoCommonData.selectedPhotoList.size(), this.mPhotoCommonData.currentQualityType);
      }
      localIntent = new Intent();
      if (this.mPhotoCommonData.selectedPhotoList != null) {
        break label263;
      }
    }
    label263:
    for (ArrayList localArrayList = new ArrayList(0);; localArrayList = this.mPhotoCommonData.selectedPhotoList)
    {
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      localNewPhotoListActivity.setResult(-1, localIntent);
      localNewPhotoListActivity.finish();
      aqfy.anim(localNewPhotoListActivity, false, false);
      return;
      if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera")))
      {
        anpc.a(localNewPhotoListActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        break;
      }
      anpc.a(localNewPhotoListActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvy
 * JD-Core Version:    0.7.0.1
 */