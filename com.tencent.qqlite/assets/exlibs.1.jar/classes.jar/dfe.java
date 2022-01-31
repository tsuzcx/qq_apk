import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.emosm.EmosmPb.BqAssocInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dfe
  implements EmosmHandler.EmosmHandlerListener
{
  public dfe(EmotionPreviewLayout paramEmotionPreviewLayout, EmosmHandler paramEmosmHandler) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    if (paramInt == 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_JavaUtilList.size() > 0)) {}
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_b_of_type_JavaUtilList = new ArrayList();
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString())) && (paramBoolean))
      {
        Iterator localIterator = paramEmosmResp.data.iterator();
        paramInt = 1;
        EmosmPb.BqAssocInfo localBqAssocInfo;
        EmoticonKeywordForCloud localEmoticonKeywordForCloud;
        do
        {
          i = paramInt;
          if (!localIterator.hasNext()) {
            break;
          }
          localBqAssocInfo = (EmosmPb.BqAssocInfo)localIterator.next();
          localEmoticonKeywordForCloud = new EmoticonKeywordForCloud();
          localEmoticonKeywordForCloud.loadedType = 0;
          localEmoticonKeywordForCloud.epId = String.valueOf(localBqAssocInfo.u32_tab_id.get());
          localEmoticonKeywordForCloud.eId = localBqAssocInfo.str_item_id.get();
          localEmoticonKeywordForCloud.name = localBqAssocInfo.str_item_name.get();
          localEmoticonKeywordForCloud.encryptKey = localBqAssocInfo.str_item_key.get();
        } while ((TextUtils.isEmpty(localEmoticonKeywordForCloud.epId)) || (TextUtils.isEmpty(localEmoticonKeywordForCloud.eId)) || (TextUtils.isEmpty(localEmoticonKeywordForCloud.encryptKey)));
        paramEmosmResp = localBqAssocInfo.rpt_str_item_keyword.get();
        if ((paramEmosmResp != null) && (paramEmosmResp.size() > 0))
        {
          paramEmosmResp = paramEmosmResp.toString();
          label261:
          localEmoticonKeywordForCloud.keyword = paramEmosmResp;
          localEmoticonKeywordForCloud.keywords = paramEmosmResp;
          if (localBqAssocInfo.i32_tab_ringtype.get() <= 3) {
            break label374;
          }
        }
        label374:
        for (paramBoolean = true;; paramBoolean = false)
        {
          localEmoticonKeywordForCloud.isSound = paramBoolean;
          localEmoticonKeywordForCloud.jobType = 0;
          localEmoticonKeywordForCloud.width = 200;
          localEmoticonKeywordForCloud.height = 200;
          localEmoticonKeywordForCloud._index = (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.e + paramInt);
          localEmoticonKeywordForCloud.valid = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_b_of_type_JavaUtilList.add(localEmoticonKeywordForCloud);
          paramInt += 1;
          break;
          paramEmosmResp = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
          break label261;
        }
      }
      int i = 1;
      if (1 != i) {
        break label451;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.e > 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler, 10000));
    return;
    label451:
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPreviewLayout.jdField_a_of_type_AndroidOsHandler, 10001));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfe
 * JD-Core Version:    0.7.0.1
 */