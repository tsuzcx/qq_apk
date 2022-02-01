import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class zva
  extends ztv
{
  private aqmd a;
  boolean btH = false;
  boolean btI = false;
  boolean btJ = false;
  boolean isFromAIO = false;
  
  zva(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean VT()
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((NewPhotoListActivity)this.mActivity).getMediaType(str) == 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject = new Pair(new ArrayList(), new ArrayList());
    boolean bool;
    if (this.jdField_a_of_type_Aqmd != null)
    {
      localObject = this.jdField_a_of_type_Aqmd;
      if (this.mPhotoCommonData.currentQualityType == 2)
      {
        bool = true;
        paramArrayList = ((aqmd)localObject).a(paramArrayList, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
        paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)paramArrayList.second);
      }
    }
    for (;;)
    {
      super.a(paramIntent, paramBoolean, (ArrayList)paramArrayList.first);
      return;
      bool = false;
      break;
      ((ArrayList)((Pair)localObject).first).addAll(paramArrayList);
      paramArrayList = (ArrayList<String>)localObject;
    }
  }
  
  public boolean addAndRemovePhotoByGesture(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = super.addAndRemovePhotoByGesture(paramLocalMediaInfo, paramBoolean);
    aqmd localaqmd;
    AbstractPhotoListActivity localAbstractPhotoListActivity;
    if ((paramBoolean) && (bool) && (this.jdField_a_of_type_Aqmd != null))
    {
      localaqmd = this.jdField_a_of_type_Aqmd;
      localAbstractPhotoListActivity = this.mActivity;
      paramLocalMediaInfo = paramLocalMediaInfo.path;
      if (this.mPhotoCommonData.currentQualityType != 2) {
        break label79;
      }
    }
    label79:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localaqmd.a(localAbstractPhotoListActivity, paramLocalMediaInfo, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
      return bool;
    }
  }
  
  protected void b(LocalMediaInfo paramLocalMediaInfo)
  {
    super.b(paramLocalMediaInfo);
    paramLocalMediaInfo = paramLocalMediaInfo.path;
    if (this.jdField_a_of_type_Ztu.cancelPresendPathSet.contains(paramLocalMediaInfo)) {
      this.jdField_a_of_type_Ztu.cancelPresendPathSet.remove(paramLocalMediaInfo);
    }
    this.jdField_a_of_type_Ztu.presendPathSet.add(paramLocalMediaInfo);
  }
  
  protected void c(LocalMediaInfo paramLocalMediaInfo)
  {
    super.c(paramLocalMediaInfo);
    if (this.jdField_a_of_type_Ztu.presendPathSet.contains(paramLocalMediaInfo.path))
    {
      this.jdField_a_of_type_Ztu.presendPathSet.remove(paramLocalMediaInfo.path);
      return;
    }
    this.jdField_a_of_type_Ztu.cancelPresendPathSet.add(paramLocalMediaInfo.path);
  }
  
  protected void cK(Intent paramIntent)
  {
    if (this.btJ)
    {
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 100018);
      return;
    }
    super.cK(paramIntent);
  }
  
  public void cN(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    String str2 = paramIntent.getStringExtra("key_multi_edit_source_path");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(str2, str1);
      zsh.a(this.mActivity, this.jdField_a_of_type_Ztu.hy, localHashMap);
      this.mPhotoCommonData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      int i = this.mPhotoCommonData.selectedPhotoList.indexOf(str2);
      if (i >= 0)
      {
        this.mPhotoCommonData.selectedPhotoList.add(i, str1);
        this.mPhotoCommonData.selectedPhotoList.remove(i + 1);
      }
    }
  }
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    localIntent.putExtra("key_pic_to_edit_from", 3);
    localIntent.putExtra("input_full_screen_mode", this.btJ);
    anot.a(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, this.mPhotoCommonData.selectedPhotoList.size() + "", "", "", "");
    if (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt).selectStatus != 1) {
      if (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) {
        break label164;
      }
    }
    label164:
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      return super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void caseVideo(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt).selectStatus != 1) {
      if (this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum) {
        break label81;
      }
    }
    label81:
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      super.caseVideo(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
  
  protected void d(LocalMediaInfo paramLocalMediaInfo)
  {
    String str = paramLocalMediaInfo.path;
    String[] arrayOfString = MimeHelper.getMimeType(paramLocalMediaInfo.mMimeType);
    Object localObject;
    AbstractPhotoListActivity localAbstractPhotoListActivity;
    if (this.jdField_a_of_type_Aqmd != null)
    {
      localObject = this.jdField_a_of_type_Aqmd;
      localAbstractPhotoListActivity = this.mActivity;
      if (this.mPhotoCommonData.currentQualityType != 2) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      ((aqmd)localObject).a(localAbstractPhotoListActivity, str, bool, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap, true);
      localObject = PresendPicMgr.a();
      if ((localObject != null) && (arrayOfString != null) && (arrayOfString[0] != null) && (!"video".equals(arrayOfString[0]))) {
        ((PresendPicMgr)localObject).ay(str, 1052, ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("entrance", 0));
      }
      super.d(paramLocalMediaInfo);
      return;
    }
  }
  
  public Intent e(Intent paramIntent)
  {
    Object localObject1 = (HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap");
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        if (this.mPhotoCommonData.selectedPhotoList.contains(str))
        {
          int i = this.mPhotoCommonData.selectedPhotoList.indexOf(str);
          this.mPhotoCommonData.selectedPhotoList.add(i, ((Map.Entry)localObject2).getValue());
          this.mPhotoCommonData.selectedPhotoList.remove(i + 1);
        }
      }
    }
    localObject1 = new Intent();
    Object localObject2 = new ArrayList();
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {
      ((ArrayList)localObject2).addAll(this.mPhotoCommonData.selectedPhotoList);
    }
    for (;;)
    {
      ((Intent)localObject1).putStringArrayListExtra("input_full_screen_mode_result", (ArrayList)localObject2);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_SIZE_SPEC", this.mPhotoCommonData.currentQualityType);
      return localObject1;
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (paramIntent.size() > 0)) {
        ((ArrayList)localObject2).addAll(paramIntent);
      }
    }
  }
  
  protected void e(LocalMediaInfo paramLocalMediaInfo)
  {
    String str = paramLocalMediaInfo.path;
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a();
    if (localPresendPicMgr != null) {
      localPresendPicMgr.fx(str, 1013);
    }
    super.e(paramLocalMediaInfo);
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Ztu.sessionInfo != null)
    {
      int i = PhotoUtils.d(this.jdField_a_of_type_Ztu.sessionInfo);
      anot.a(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X800A915", "0X800A915", i, 0, "", "", "", "");
    }
    super.enterAlbumListFragment(paramIntent);
  }
  
  public void enterPhotoPreviewActivity(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("key_pic_to_edit_from", 2);
    paramIntent.putExtra("input_full_screen_mode", this.btJ);
    super.enterPhotoPreviewActivity(paramBoolean, paramIntent);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int j = this.mPhotoCommonData.maxSelectNum;
    paramLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).getResources();
    if (this.btJ) {}
    for (int i = 2131696893;; i = 2131696894) {
      return paramLocalMediaInfo.getString(i, new Object[] { Integer.valueOf(j) });
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.mPhotoCommonData.needMediaInfo = true;
    this.btH = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.initData(paramIntent);
    this.jdField_a_of_type_Ztu.isSupportVideoCheckbox = true;
    this.jdField_a_of_type_Ztu.isSingleMode = false;
    this.jdField_a_of_type_Ztu.btm = true;
    this.jdField_a_of_type_Ztu.btk = true;
    this.jdField_a_of_type_Ztu.filter.setSupportWebp(true);
    this.isFromAIO = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.btJ = paramIntent.getBooleanExtra("input_full_screen_mode", false);
    this.jdField_a_of_type_Ztu.customSendBtnText = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696942);
    if (this.btJ) {
      this.jdField_a_of_type_Ztu.customSendBtnText = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131696878);
    }
    if (this.mPhotoCommonData.currentQualityType == 2) {
      this.btI = true;
    }
    paramIntent = new aqmd().a(((zuc)this.mOtherCommonData).cfh).b(this.mPhotoCommonData.videoSizeLimit);
    if ((!this.btH) && (!this.jdField_a_of_type_Ztu.btr)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Aqmd = paramIntent.a(bool);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && ((paramInt1 == 100017) || (paramInt1 == 100018)))
    {
      switch (paramInt1)
      {
      default: 
        return;
      case 100017: 
        paramIntent = e(paramIntent);
        ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
        ((NewPhotoListActivity)this.mActivity).finish();
        return;
      }
      cN(paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "current select count:" + localArrayList.size());
    }
    int k = paramView.selectStatus;
    int i;
    if ((k != 1) && (localArrayList.size() >= this.mPhotoCommonData.maxSelectNum))
    {
      i = 1;
      if (i == 0) {
        break label205;
      }
    }
    label205:
    for (int j = 2;; j = 1)
    {
      anot.a(null, "dc00898", "", "", "0X800AB6C", "0X800AB6C", j, 0, "", "", "", "");
      if (i == 0) {
        break label211;
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Ztu.lastTimeShowToast >= 1000L)
      {
        QQToast.a(this.mActivity, getExceedMaxSelectNumStr(paramView), 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_Ztu.lastTimeShowToast = l;
        crT();
      }
      return;
      i = 0;
      break;
    }
    label211:
    if ((this.btJ) && (paramView.fileSize > 31457280L))
    {
      QQToast.a(this.mActivity, 2131696944, 0).show(((NewPhotoListActivity)this.mActivity).mTitleBarHeight);
      paramCheckBox.setChecked(false);
      return;
    }
    if (k == 1)
    {
      i = 2;
      paramView.selectStatus = i;
      if (paramView.selectStatus != 1) {
        break label342;
      }
      bool = true;
      label286:
      if (!bool) {
        break label348;
      }
      d(paramView);
      label296:
      ((NewPhotoListActivity)this.mActivity).updateCheckbox(paramInt, bool);
      paramView = (NewPhotoListActivity)this.mActivity;
      if (bool) {
        break label356;
      }
    }
    label342:
    label348:
    label356:
    for (boolean bool = true;; bool = false)
    {
      paramView.selectLimitRemind(bool);
      updateButton();
      return;
      i = 1;
      break;
      bool = false;
      break label286;
      e(paramView);
      break label296;
    }
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    super.onPreviewBtnClick(paramView);
    anot.a(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, this.mPhotoCommonData.selectedPhotoList.size() + "", "", "", "");
  }
  
  public void onQualityBtnClick(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Aqmd != null)
      {
        if (!this.btI) {
          this.jdField_a_of_type_Aqmd.a(this.mActivity, this.mPhotoCommonData.selectedPhotoList, paramBoolean, this.mPhotoCommonData.selectedMediaInfoHashMap, this.mPhotoCommonData.allMediaInfoHashMap);
        }
      }
      else
      {
        this.mPhotoCommonData.currentQualityType = 2;
        ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setChecked(true);
        ((NewPhotoListActivity)this.mActivity).Nn.setVisibility(0);
        cfa();
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Ztu.btl) {
        ((NewPhotoListActivity)this.mActivity).Nn.setVisibility(8);
      }
      return;
      this.btI = false;
      break;
      this.mPhotoCommonData.currentQualityType = 0;
      ((NewPhotoListActivity)this.mActivity).qualityCheckBox.setChecked(false);
      ((NewPhotoListActivity)this.mActivity).Nn.setVisibility(4);
    }
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    if (this.jdField_a_of_type_Ztu.sessionInfo != null)
    {
      int i = PhotoUtils.d(this.jdField_a_of_type_Ztu.sessionInfo);
      anot.a(null, "CliOper", "", this.mPhotoCommonData.myUin, "0X800A916", "0X800A916", i, 0, "", "", "", "");
    }
    super.onTitleBtnCancelClick(paramView);
  }
  
  public List<LocalMediaInfo> queryPhotoList()
  {
    long l = System.currentTimeMillis();
    List localList = super.queryPhotoList();
    HashMap localHashMap;
    boolean bool;
    if ((localList != null) && (localList.size() >= 1000))
    {
      localHashMap = new HashMap();
      l = System.currentTimeMillis() - l;
      if (this.mPhotoCommonData.albumName != null) {
        break label166;
      }
      bool = true;
      if (!bool) {
        break label171;
      }
    }
    label166:
    label171:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isRecent", str);
      localHashMap.put("duration", "" + l);
      localHashMap.put("mediaQuantity", "" + localList.size());
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "album_query_media", bool, l, localList.size(), localHashMap, null);
      return localList;
      bool = false;
      break;
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (this.btJ)
    {
      ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 100017);
      return;
    }
    super.startPhotoPreviewActivity(paramIntent);
  }
  
  protected void submit()
  {
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
    if ((this.isFromAIO) && (((zuc)this.mOtherCommonData).selectedQzonePhotos != null) && (((zuc)this.mOtherCommonData).selectedQzonePhotos.size() > 0))
    {
      if (this.mPhotoCommonData.albumId.equals("$RecentAlbumId")) {
        anpc.a(this.mActivity).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      }
      for (;;)
      {
        a(localIntent, true, this.mPhotoCommonData.selectedPhotoList);
        return;
        if ((this.mPhotoCommonData.albumName.equalsIgnoreCase("Camera")) || (this.mPhotoCommonData.albumName.equalsIgnoreCase("camera")) || (this.mPhotoCommonData.albumName.contains("Camera")) || (this.mPhotoCommonData.albumName.contains("camera"))) {
          anpc.a(this.mActivity).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        } else {
          anpc.a(this.mActivity).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
        }
      }
    }
    if (this.btJ)
    {
      localIntent = u();
      ((NewPhotoListActivity)this.mActivity).setResult(-1, localIntent);
      onBackPressed();
      return;
    }
    super.submit();
  }
  
  public Intent u()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.mPhotoCommonData.selectedPhotoList);
    localIntent.putStringArrayListExtra("input_full_screen_mode_result", localArrayList);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.mPhotoCommonData.currentQualityType);
    return localIntent;
  }
  
  public void updateButton()
  {
    super.updateButton();
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((((zuc)this.mOtherCommonData).selectedQzonePhotos == null) || (((zuc)this.mOtherCommonData).selectedQzonePhotos.size() <= 0) || (this.mPhotoCommonData.selectedPhotoList.size() != ((zuc)this.mOtherCommonData).selectedQzonePhotos.size())) {
          break;
        }
        ((NewPhotoListActivity)this.mActivity).magicStickBtn.setEnabled(false);
      }
      return;
    }
    if (VT())
    {
      ((NewPhotoListActivity)this.mActivity).magicStickBtn.setEnabled(false);
      return;
    }
    Button localButton = ((NewPhotoListActivity)this.mActivity).magicStickBtn;
    if (this.mPhotoCommonData.selectedPhotoList.size() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zva
 * JD-Core Version:    0.7.0.1
 */