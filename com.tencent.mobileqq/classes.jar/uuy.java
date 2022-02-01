import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$Companion;", "", "()V", "FROM_BIU", "", "FROM_COLUMN_DETAIL", "FROM_COMMENT", "FROM_COMMENT_CARD", "FROM_MY_INFO_CARD", "FROM_NATIVE_ARTICLE", "FROM_OTHER", "FROM_SHORT_CONTENT_CARD", "FROM_SHORT_CONTENT_DETAIL", "FROM_SHORT_CONTENT_FLOAT", "FROM_TOPIC", "FROM_UGC", "FROM_UGC_SOCIAL", "FROM_VIDEO_CARD", "FROM_VIDEO_MULTI", "FROM_VIDEO_ONE_TO_THREE", "FROM_WEB_ARTICLE", "MSG_SCREENSHOT_SAVED", "REQUEST_CODE_SHARE_TO_QZONE", "RIJ_FONT_SIZE_INDEX_SP", "", "RIJ_FONT_SIZE_RATIO_SP", "RIJ_FONT_SIZE_SP", "RIJ_SHARE_TITLE", "SHARE_UNIT_ADD_COLOR_NOTE", "SHARE_UNIT_ADD_FAVORITE", "SHARE_UNIT_ADD_FRIEND", "SHARE_UNIT_ADD_TO_COLUMN", "SHARE_UNIT_ADJUST_FONT_SIZE", "SHARE_UNIT_COPY_LINK", "SHARE_UNIT_DELETE_COLUMN", "SHARE_UNIT_DIS_LIKE", "SHARE_UNIT_EXPORT_DOCS", "SHARE_UNIT_MORE_INFO", "SHARE_UNIT_OPEN_AIO", "SHARE_UNIT_PERSONAL_C2C", "SHARE_UNIT_QR_CODE", "SHARE_UNIT_REMOVE_COLOR_NOTE", "SHARE_UNIT_REMOVE_FANS", "SHARE_UNIT_REMOVE_FROM_COLUMN", "SHARE_UNIT_REPORT", "SHARE_UNIT_SAVE_PIC", "SHARE_UNIT_SCREEN_SHOT", "SHARE_UNIT_SEND_TO_PC", "SHARE_UNIT_SEND_TO_QQ_BROWSER", "SHARE_UNIT_SEND_TO_QQ_FRIEND", "SHARE_UNIT_SEND_TO_QZONE", "SHARE_UNIT_SEND_TO_READINJOY", "SHARE_UNIT_SEND_TO_RECENT_FRIEND", "SHARE_UNIT_SEND_TO_SYS_BROWSER", "SHARE_UNIT_SEND_TO_WECHAT", "SHARE_UNIT_SEND_TO_WECHAT_CIRCLE", "SHARE_UNIT_SEND_TO_WEIBO", "SHARE_UNIT_SHIELD", "SHARE_UNIT_UNKNOWN", "SHARE_UNIT_WATCH_WORD", "TAG", "nameToAction", "", "actionToShareUnit", "action", "getDefaultActionItemLine1", "", "Lcom/tencent/biz/pubaccount/util/ActionItem;", "getDefaultActionItemLine2", "getWholeLineOneItems", "parseWebLineFromJson", "lineArr", "Lorg/json/JSONArray;", "jsonObject", "Lorg/json/JSONObject;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uuy
{
  public final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 72: 
      return 1;
    case 13: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    case 9: 
      return 5;
    case 10: 
      return 6;
    case 12: 
      return 7;
    case 4: 
      return 8;
    case 5: 
      return 9;
    case 70: 
      return 10;
    case 6: 
      return 11;
    case 68: 
      return 12;
    case 26: 
      return 13;
    case 1: 
      return 14;
    case 11: 
      return 15;
    case 38: 
      return 16;
    case 23: 
      return 17;
    case 133: 
      return 18;
    case 82: 
      return 19;
    case 40: 
      return 20;
    case 134: 
      return 21;
    case 136: 
      return 22;
    case 35: 
      return 23;
    case 37: 
      return 24;
    case 137: 
      return 25;
    case 31: 
      return 26;
    case 138: 
      return 27;
    case 43: 
      return 28;
    case 44: 
      return 29;
    case 21: 
      return 30;
    }
    return 31;
  }
  
  @JvmStatic
  @NotNull
  public final List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList(9);
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    localArrayList.add(Integer.valueOf(12));
    localArrayList.add(Integer.valueOf(26));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(4));
    return (List)localArrayList;
  }
  
  @JvmStatic
  @NotNull
  public final List<urb> a(@NotNull JSONArray paramJSONArray, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONArray, "lineArr");
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    int m;
    int j;
    label192:
    boolean bool;
    for (;;)
    {
      try
      {
        int k = paramJSONArray.length();
        i = 0;
        if (i >= k) {
          break label245;
        }
        localObject2 = paramJSONArray.get(i);
        if ((localObject2 instanceof String))
        {
          localObject1 = (Integer)uuw.a().get(localObject2);
          if (localObject1 == null) {
            break label334;
          }
          localArrayList.add(new urb((String)localObject2, ((Integer)localObject1).intValue(), false));
          break label334;
        }
        if (!(localObject2 instanceof JSONObject)) {
          break label334;
        }
        localObject1 = ((JSONObject)localObject2).optString("name");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (uuw.a().get(localObject1) == null)) {
          break label334;
        }
        m = ((JSONObject)localObject2).optInt("webHandle", 0);
        if ((!Intrinsics.areEqual("save_picture", localObject1)) || (paramJSONObject == null)) {
          break;
        }
        localObject2 = (Integer)uuw.a().get(localObject1);
        if (localObject2 == null) {
          break label251;
        }
        j = ((Integer)localObject2).intValue();
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("ReadInJoyShareHelperV2", 1, QLog.getStackTraceString((Throwable)paramJSONArray));
      }
      localObject2 = paramJSONObject.optString("saveImageUrl");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "jsonObject.optString(\"saveImageUrl\")");
      localArrayList.add(new urt((String)localObject1, j, bool, (String)localObject2));
      break label334;
      label245:
      return (List)localArrayList;
      label251:
      j = 0;
      break label341;
      label257:
      bool = false;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "name");
    Object localObject2 = (Integer)uuw.a().get(localObject1);
    if (localObject2 != null) {
      j = ((Integer)localObject2).intValue();
    }
    for (;;)
    {
      label300:
      localArrayList.add(new urb((String)localObject1, j, bool));
      break label334;
      j = 0;
      label334:
      label341:
      while (m != 1)
      {
        bool = false;
        break label300;
        i += 1;
        break;
        if (m != 1) {
          break label257;
        }
        bool = true;
        break label192;
      }
      bool = true;
    }
  }
  
  @JvmStatic
  @NotNull
  public final List<urb> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new urb("kandian", 13, false));
    localArrayList.add(new urb("qq_friend", 2, false));
    localArrayList.add(new urb("qzone", 3, false));
    localArrayList.add(new urb("we_chat", 9, false));
    localArrayList.add(new urb("we_chat_circle", 10, false));
    localArrayList.add(new urb("we_bo", 12, false));
    localArrayList.add(new urb("send_pc", 26, false));
    localArrayList.add(new urb("qq_browser", 5, false));
    localArrayList.add(new urb("sys_browser", 4, false));
    return (List)localArrayList;
  }
  
  @JvmStatic
  @NotNull
  public final List<urb> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new urb("screen_shot", 21, false));
    localArrayList.add(new urb("set_font", 7, false));
    localArrayList.add(new urb("add_favourite", 6, false));
    localArrayList.add(new urb("copy_link", 1, false));
    localArrayList.add(new urb("report", 11, false));
    return (List)localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuy
 * JD-Core Version:    0.7.0.1
 */