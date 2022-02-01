import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public abstract class awva<K extends awur>
  implements MediaScanner.OnMediaScannerListener
{
  protected static volatile awva b;
  public awva.a a;
  public awva.b a;
  public awva.c a;
  awva.d a = null;
  public WeakReference<K> bu;
  public PhotoCommonBaseData<OtherCommonData> mPhotoCommonData;
  public PhotoListBaseData mPhotoListData;
  
  protected awva(K paramK)
  {
    this.bu = new WeakReference(paramK);
    paramK.getActivity().getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true);
    this.mPhotoCommonData = PhotoCommonBaseData.getInstance();
    paramK.getActivity().getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.mPhotoCommonData.addHoldNember();
    this.mPhotoListData = new PhotoListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic new，fragment = " + paramK + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
  }
  
  public abstract void bq(float paramFloat);
  
  public abstract void bu(ArrayList<LocalMediaInfo> paramArrayList);
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic close，fragment = " + this.bu.get() + ",PhotoCommonData = " + this.mPhotoCommonData);
    }
    this.mPhotoCommonData.releaseCommonData();
    b = null;
  }
  
  public abstract void cw(int paramInt, boolean paramBoolean);
  
  public abstract void doOnDestroy();
  
  public abstract void doOnResume();
  
  public abstract void eGv();
  
  public abstract void enterAlbumListFragment(Intent paramIntent);
  
  abstract void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent);
  
  abstract String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo);
  
  public abstract List<LocalMediaInfo> getLocalMediaInfos();
  
  public abstract void handleVideoEncodeSucceed(Message paramMessage);
  
  public abstract void initData(Intent paramIntent);
  
  public abstract void jk(View paramView);
  
  public abstract void jl(View paramView);
  
  public abstract boolean needVedio();
  
  public void onAlbumListShown(boolean paramBoolean) {}
  
  public abstract void onMagicStickClick(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent);
  
  public abstract void onPreviewBtnClick(View paramView);
  
  public abstract void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  public abstract boolean onQueryPhoto(List<LocalMediaInfo> paramList);
  
  public abstract void onScrollStart(int paramInt);
  
  public abstract void onSendBtnClick(View paramView);
  
  public abstract void onTitleBtnCancelClick(View paramView);
  
  public abstract void postInitUI();
  
  public abstract void processQueryResult(List<LocalMediaInfo> paramList);
  
  public abstract void startPhotoPreviewActivity(Intent paramIntent);
  
  public abstract void updateButton();
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, awur.c paramc, awur.b paramb);
    
    public abstract void b(int paramInt, awur.c paramc, awur.b paramb);
    
    public abstract void c(int paramInt, awur.c paramc, awur.b paramb);
    
    public abstract View cG();
    
    public abstract View cH();
    
    public abstract View cI();
  }
  
  public static abstract interface b
  {
    public abstract void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox);
  }
  
  public static abstract interface c
  {
    public abstract Intent a(View paramView, int paramInt);
    
    public abstract void aF(View paramView, int paramInt);
    
    public abstract void aG(View paramView, int paramInt);
    
    public abstract void aH(View paramView, int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void onSelectionChange(boolean paramBoolean, LocalMediaInfo paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awva
 * JD-Core Version:    0.7.0.1
 */