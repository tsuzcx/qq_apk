import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class bvm
  extends bvu
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PicEmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  public bvm(MarketFaceItemBuilder paramMarketFaceItemBuilder)
  {
    super(paramMarketFaceItemBuilder, null);
  }
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, PicEmoticonInfo paramPicEmoticonInfo, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramPicEmoticonInfo;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = paramQQProgressDialog;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.a() == 3)
    {
      EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39);
      Object localObject1 = paramDownloadTask.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
      Object localObject2 = EmosmUtils.getEmosmJsonUrl(localEmoticonPackage.epId);
      int i = ((Bundle)localObject1).getInt("jsonType", EmojiManager.c);
      paramDownloadTask = (File)paramDownloadTask.a.get(localObject2);
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      ReqInfo localReqInfo = new ReqInfo();
      if (paramDownloadTask.exists())
      {
        paramDownloadTask = FileUtils.a(paramDownloadTask);
        if (localEmojiManager.a(localEmoticonPackage, i, paramDownloadTask, (ArrayList)localObject1, (ArrayList)localObject2, localReqInfo) == null) {
          break label137;
        }
      }
      label137:
      while (Long.parseLong(localEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))
      {
        return;
        paramDownloadTask = null;
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      EmosmDetailActivity.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    EmosmDetailActivity.a(this.jdField_a_of_type_Int + 1000, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, null, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bvm
 * JD-Core Version:    0.7.0.1
 */