import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class agnv
  extends amtl
{
  private BitmapFactory.Options e = new BitmapFactory.Options();
  
  public agnv(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    paramamxy.getTitleView().setMaxWidth(800);
    Object localObject = (agns)paramampx;
    ImageView localImageView = paramamxy.w();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((agns)localObject).Br == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((agns)localObject).Br.get(0);
    int i = ahav.getFileType(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (aqhq.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramamxy.w().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramamxy.w().getWidth();
        paramamxy = paramamxy.O();
        if ((paramamxy != null) && (!TextUtils.isEmpty(paramampx.g())))
        {
          paramamxy.setText(paramampx.g());
          paramamxy.setVisibility(0);
        }
        paramampx = ahbh.a(localFileManagerEntity);
        if (paramampx == null) {
          break;
        }
        paramampx = URLDrawable.getDrawable(paramampx, (URLDrawable.URLDrawableOptions)localObject);
        if (paramampx == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130845173));
        }
        localImageView.setImageDrawable(paramampx);
        return;
        if (aqhq.fileExistsAndNotEmpty(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!aqhq.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
            break label265;
          }
          localFileManagerEntity.getFilePath();
        }
      }
      label265:
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localFileManagerEntity.getCloudType() == 1) {
        localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity, 7);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130845173));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        ahav.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
    if ((paramamxy.getTitleView() != null) && (!TextUtils.isEmpty(paramampx.getTitle())))
    {
      paramamxy.getTitleView().setVisibility(0);
      paramamxy.getTitleView().setText(paramampx.getTitle());
    }
    if ((paramamxy.z() != null) && (!TextUtils.isEmpty(paramampx.f())))
    {
      paramamxy.z().setVisibility(0);
      paramamxy.z().setText(paramampx.f());
    }
    if ((paramamxy.N() != null) && (!TextUtils.isEmpty(paramampx.getDescription())))
    {
      paramamxy.N().setVisibility(0);
      paramamxy.N().setText(paramampx.getDescription());
    }
    if ((paramampx.g() == null) && (paramamxy.O() != null)) {
      paramamxy.O().setVisibility(8);
    }
    if ((paramamxy.O() != null) && (paramampx.g() != null))
    {
      paramamxy.O().setVisibility(0);
      paramamxy.O().setText(paramampx.g());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agnv
 * JD-Core Version:    0.7.0.1
 */