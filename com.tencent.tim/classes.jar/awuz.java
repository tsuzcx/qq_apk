import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;

public class awuz
  extends awuy<awuu>
  implements awux.a
{
  protected zto a;
  protected final boolean baw = axiz.aOK();
  
  protected awuz(awuu paramawuu)
  {
    super(paramawuu);
    this.jdField_b_of_type_Awux$a = this;
    this.mAlbumListData = new zto();
    this.a = ((zto)this.mAlbumListData);
  }
  
  public static awux a(awuu paramawuu)
  {
    if ((jdField_b_of_type_Awux == null) || (jdField_b_of_type_Awux.bu.get() != paramawuu)) {}
    try
    {
      if ((jdField_b_of_type_Awux == null) || (jdField_b_of_type_Awux.bu.get() != paramawuu)) {
        jdField_b_of_type_Awux = new awuz(paramawuu);
      }
      return jdField_b_of_type_Awux;
    }
    finally {}
  }
  
  protected awul a()
  {
    return new awum((awuu)this.bu.get());
  }
  
  protected awum a()
  {
    return (awum)super.b();
  }
  
  public String adapterGenerateSelection()
  {
    return super.adapterGenerateSelection();
  }
  
  public List<QQAlbumInfo> compact(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    paramList1 = super.compact(paramList1, paramList2, paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty()) && (paramInt == -1) && (a().isShowQzoneAlbum) && (a().Ly > 0L))
    {
      paramList2 = new QQAlbumInfo();
      paramList2._id = "qzone_album";
      paramList2.name = "空间相册";
      paramList2.mMediaFileCount = ((int)a().Ly);
      paramList1.add(0, paramList2);
    }
    return paramList1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = a();
    Object localObject = paramViewGroup.getItem(paramInt);
    TextView localTextView = (TextView)paramView;
    if (((QQAlbumInfo)localObject)._id.equals("qzone_album"))
    {
      localObject = paramViewGroup.mResources.getDrawable(2130848527);
      ((Drawable)localObject).setBounds(0, 0, paramViewGroup.mCoverWidth, paramViewGroup.mCoverHeight);
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    paramView.setBackgroundResource(2130837742);
    localTextView.setTextColor(paramViewGroup.mResources.getColor(2131165381));
    return paramView;
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a.bti = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.mPhotoCommonData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    String str2 = paramIntent.getStringExtra("peak.myUin");
    String str1 = str2;
    if (str2 == null) {
      str1 = axol.getAppInterface().getCurrentAccountUin();
    }
    if (str1 != null) {
      this.mPhotoCommonData.myUin = str1;
    }
    if (this.mPhotoCommonData.myUin == null) {
      throw new RuntimeException("must set MY_UIN");
    }
    this.mPhotoCommonData.mIsDisableTroopAlbum = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.mPhotoCommonData.mIsDisableTroopAlbum);
    if (this.mPhotoCommonData.isShowQzoneAlbum)
    {
      paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), anem.class);
      paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this.a.c);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
    }
  }
  
  boolean needUpdateAlbum(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return (!paramQQAlbumInfo._id.equals("qzone_album")) && (paramBoolean);
  }
  
  public boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    Object localObject;
    if (paramQQAlbumInfo._id.equals("qzone_album"))
    {
      localObject = paramIntent.getExtras();
      ((Bundle)localObject).putInt("key_personal_album_enter_model", 1);
      ((Bundle)localObject).putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      ((Bundle)localObject).putSerializable("PhotoConst.PHOTO_INFOS", paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      ((Bundle)localObject).putStringArrayList("PhotoConst.PHOTO_PATHS", paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      avpw.d locald = avpw.d.a();
      locald.cMP = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ((Bundle)localObject).putString("keyAction", "actionSelectPicture");
      ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
      avpw.a(((awuu)this.bu.get()).getActivity(), locald, (Bundle)localObject, 100016);
      return checkAlbumChange(paramIntent, paramQQAlbumInfo);
    }
    if (paramQQAlbumInfo._id.equals("$CustomAlbumId"))
    {
      localObject = rma.a().ci();
      if (((List)localObject).size() > 0) {
        paramIntent.putExtra("ALBUM_NAME", ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName);
      }
      paramIntent.putExtra("ALBUM_ID", "$CustomAlbumId");
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
      paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
      paramIntent.putExtra("report_first_exposure", true);
      paramIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
      paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", false);
      return checkAlbumChange(paramIntent, paramQQAlbumInfo);
    }
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    if ("$VideoAlbumId".equals(paramQQAlbumInfo._id)) {
      anot.a(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
    }
    return super.onItemClick(paramQQAlbumInfo, paramInt, paramIntent);
  }
  
  public void postInitUI() {}
  
  public void queryAlbumList(int paramInt)
  {
    super.queryAlbumList(paramInt);
  }
  
  public List<LocalMediaInfo> queryRecentImageList(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return super.queryRecentImageList(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awuz
 * JD-Core Version:    0.7.0.1
 */