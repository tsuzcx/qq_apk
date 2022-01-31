package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonUtils
{
  private static final String jdField_a_of_type_JavaLangString = "EmoticonUtils";
  public static HashMap a;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "😄", "😃", "😀", "😊", "☺", "😉", "😍", "😘", "😚", "😗", "😙", "😜", "😝", "😛", "😳", "😁", "😔", "😌", "😒", "😞", "😣", "😢", "😂", "😭", "😪", "😥", "😰", "😅", "😓", "😩", "😫", "😨", "😱", "😠", "😡", "😤", "😖", "😆", "😋", "😷", "😎", "😴", "😵", "😲", "😟", "😦", "😧", "😈", "👿", "😮", "😬", "😐", "😕", "😯", "😶", "😇", "😏", "😑", "👲", "👳", "👮", "👷", "💂", "👶", "👦", "👧", "👨", "👩", "👴", "👵", "👱", "👼", "👸", "😺", "😸", "😻", "😽", "😼", "🙀", "😿", "😹", "😾", "👹", "👺", "🙈", "🙉", "🙊", "💀", "👽", "💩", "🔥", "✨", "🌟", "💫", "💥", "💢", "💦", "💧", "💤", "💨", "👂", "👀", "👃", "👅", "👄", "👍", "👎", "👌", "👊", "✊", "✌", "👋", "✋", "👐", "👆", "👇", "👉", "👈", "🙌", "🙏", "☝", "👏", "💪", "🚶", "🏃", "💃", "👫", "👪", "👬", "👭", "💏", "💑", "👯", "🙆", "🙅", "💁", "🙋", "💆", "💇", "💅", "👰", "🙎", "🙍", "🙇", "🎩", "👑", "👒", "👟", "👞", "👡", "👠", "👢", "👕", "👔", "👚", "👗", "🎽", "👖", "👘", "👙", "💼", "👜", "👝", "👛", "👓", "🎀", "🌂", "💄", "💛", "💙", "💜", "💚", "❤", "💔", "💗", "💓", "💕", "💖", "💞", "💘", "💌", "💋", "💍", "💎", "👤", "👥", "💬", "👣", "💭", "🐶", "🐺", "🐱", "🐭", "🐹", "🐰", "🐸", "🐯", "🐨", "🐻", "🐷", "🐽", "🐮", "🐗", "🐵", "🐒", "🐴", "🐑", "🐘", "🐼", "🐧", "🐦", "🐤", "🐥", "🐣", "🐔", "🐍", "🐢", "🐛", "🐝", "🐜", "🐞", "🐌", "🐙", "🐚", "🐠", "🐟", "🐬", "🐳", "🐋", "🐄", "🐏", "🐀", "🐃", "🐅", "🐇", "🐉", "🐎", "🐐", "🐓", "🐕", "🐖", "🐁", "🐂", "🐲", "🐡", "🐊", "🐫", "🐪", "🐆", "🐈", "🐩", "🐾", "💐", "🌸", "🌷", "🍀", "🌹", "🌻", "🌺", "🍁", "🍃", "🍂", "🌿", "🌾", "🍄", "🌵", "🌴", "🌲", "🌳", "🌰", "🌱", "🌼", "🌐", "🌞", "🌝", "🌚", "🌑", "🌒", "🌓", "🌔", "🌕", "🌖", "🌗", "🌘", "🌜", "🌛", "🌙", "🌍", "🌎", "🌏", "🌋", "🌌", "🌠", "⭐", "☀", "⛅", "☁", "⚡", "☔", "❄", "⛄", "🌀", "🌁", "🌈", "🌊", "🎍", "💝", "🎎", "🎒", "🎓", "🎏", "🎆", "🎇", "🎐", "🎑", "🎃", "👻", "🎅", "🎄", "🎁", "🎋", "🎉", "🎊", "🎈", "🎌", "🔮", "🎥", "📷", "📹", "📼", "💿", "📀", "💽", "💾", "💻", "📱", "☎", "📞", "📟", "📠", "📡", "📺", "📻", "🔊", "🔉", "🔈", "🔇", "🔔", "🔕", "📢", "📣", "⏳", "⌛", "⏰", "⌚", "🔓", "🔒", "🔏", "🔐", "🔑", "🔎", "💡", "🔦", "🔆", "🔅", "🔌", "🔋", "🔍", "🛁", "🛀", "🚿", "🚽", "🔧", "🔩", "🔨", "🚪", "🚬", "💣", "🔫", "🔪", "💊", "💉", "💰", "💴", "💵", "💷", "💶", "💳", "💸", "📲", "📧", "📥", "📤", "✉", "📩", "📨", "📯", "📫", "📪", "📬", "📭", "📮", "📦", "📝", "📄", "📃", "📑", "📊", "📈", "📉", "📜", "📋", "📅", "📆", "📇", "📁", "📂", "✂", "📌", "📎", "✒", "✏", "📏", "📐", "📕", "📗", "📘", "📙", "📓", "📔", "📒", "📚", "📖", "🔖", "📛", "🔬", "🔭", "📰", "🎤", "🎧", "🎼", "🎵", "🎶", "🎹", "🎻", "🎺", "🎷", "🎸", "👾", "🎮", "🃏", "🎴", "🀄", "🎲", "🎯", "🏈", "🏀", "⚽", "⚾", "🎾", "🎱", "🏉", "🎳", "⛳", "🚵", "🚴", "🏁", "🏇", "🏆", "🎿", "🏂", "🏊", "🏄", "🎣", "☕", "🍵", "🍶", "🍼", "🍺", "🍻", "🍸", "🍹", "🍷", "🍴", "🍕", "🍔", "🍟", "🍗", "🍖", "🍝", "🍛", "🍤", "🍱", "🍣", "🍥", "🍙", "🍘", "🍚", "🍜", "🍲", "🍢", "🍡", "🍳", "🍞", "🍩", "🍮", "🍦", "🍨", "🍧", "🎂", "🍰", "🍪", "🍫", "🍬", "🍭", "🍯", "🍎", "🍏", "🍊", "🍋", "🍒", "🍇", "🍉", "🍓", "🍑", "🍈", "🍌", "🍐", "🍍", "🍠", "🍆", "🍅", "🌽", "🏠", "🏡", "🏫", "🏢", "🏣", "🏥", "🏦", "🏪", "🏩", "🏨", "💒", "⛪", "🏬", "🏤", "🌇", "🌆", "🏯", "🏰", "⛺", "🏭", "🗼", "🗾", "🗻", "🌄", "🌅", "🌃", "🗽", "🌉", "🎠", "🎡", "⛲", "🎢", "🚢", "⛵", "🚤", "🚣", "⚓", "🚀", "✈", "💺", "🚁", "🚂", "🚊", "🚉", "🚞", "🚆", "🚄", "🚅", "🚈", "🚇", "🚝", "🚋", "🚃", "🚎", "🚌", "🚍", "🚙", "🚘", "🚗", "🚕", "🚖", "🚛", "🚚", "🚨", "🚓", "🚔", "🚒", "🚑", "🚐", "🚲", "🚡", "🚟", "🚠", "🚜", "💈", "🚏", "🎫", "🚦", "🚥", "⚠", "🚧", "🔰", "⛽", "🏮", "🎰", "♨", "🗿", "🎪", "🎭", "📍", "🚩", "🔟", "🔢", "🔣", "⬆", "⬇", "⬅➡", "🔠", "🔡", "🔤", "↗", "↖", "↘", "↙", "↔", "↕", "🔄", "◀", "▶", "🔼", "🔽", "↩", "↪", "ℹ", "⏪", "⏩", "⏫", "⏬", "⤵", "⤴", "🆗", "🔀", "🔁", "🔂", "🆕", "🆙", "🆒", "🆓", "🆖", "📶", "🎦", "🈁", "🈯", "🈳", "🈵", "🈴", "🈲", "🉐", "🈹", "🈺", "🈶", "🈚", "🚻", "🚹", "🚺", "🚼", "🚾", "🚰", "🚮", "🅿", "♿", "🚭", "🈷", "🈸", "🈂", "Ⓜ", "🛂", "🛄", "🛅", "🛃", "🉑", "㊙", "㊗", "🆑", "🆘", "🆔", "🚫", "🔞", "📵", "🚯", "🚱", "🚳", "🚷", "🚸", "⛔", "✳", "❇", "❎", "✅", "✴", "💟", "🆚", "📳", "📴", "🅰", "🅱", "🆎", "🅾", "💠", "➿", "♻", "♈", "♉", "♊", "♋", "♌", "♍", "♎", "♏", "♐", "♑", "♒", "♓", "⛎", "🔯", "🏧", "💹", "💲", "💱", "©", "®™", "❌", "‼", "⁉", "❗", "❓", "❕", "❔", "⭕", "🔝", "🔚", "🔙", "🔛", "🔜", "🕧", "🕐", "🕜", "🕑", "🕝", "🕒", "🕞", "🕓", "🕟", "🕔", "🕠", "🕕", "🕖", "🕗", "🕘", "🕙", "🕚", "🕡", "🕢", "🕣", "🕤", "🕥", "🕦", "✖", "➕", "➖", "➗", "♠", "♥", "♣", "♦", "💮", "💯", "✔", "☑", "🔘", "🔗", "➰", "〰", "〽", "🔱", "◼", "◻", "◾", "◽", "▪", "▫", "🔺", "🔲", "🔳", "⚫", "⚪", "🔴", "🔵", "🔻", "⬜", "⬛", "🔶", "🔷", "🔸", "🔹" };
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      int j = jdField_a_of_type_ArrayOfJavaLangString[i].codePointAt(0);
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), Integer.valueOf(i));
      i += 1;
    }
  }
  
  public static Bundle a(AppInterface paramAppInterface)
  {
    paramAppInterface = a(paramAppInterface);
    if (paramAppInterface == null) {
      return null;
    }
    try
    {
      paramAppInterface = new JSONObject(paramAppInterface).getJSONObject("addbutton");
      if (Integer.parseInt(paramAppInterface.getString("hide")) == 1) {}
      for (boolean bool = false;; bool = true)
      {
        paramAppInterface = paramAppInterface.getString("url");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("plusbutton", bool);
        localBundle.putString("url", paramAppInterface);
        return localBundle;
      }
      return null;
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public static PicEmoticonInfo a(MarkFaceMessage paramMarkFaceMessage, QQAppInterface paramQQAppInterface)
  {
    if ((paramMarkFaceMessage == null) || (paramQQAppInterface == null)) {}
    String str1;
    do
    {
      return null;
      str1 = EmosmUtils.bytes2eId(paramMarkFaceMessage.sbufID, paramMarkFaceMessage.mediaType);
    } while (str1 == null);
    String str2 = String.valueOf(paramMarkFaceMessage.dwTabID);
    int i = paramMarkFaceMessage.imageWidth;
    int j = paramMarkFaceMessage.imageHeight;
    Emoticon localEmoticon = ((EmoticonManager)paramQQAppInterface.getManager(12)).a(str2, str1);
    if (localEmoticon != null)
    {
      paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.a());
      paramQQAppInterface.b = 6;
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
      localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
      if (localEmoticon.width == 0) {
        localEmoticon.width = i;
      }
      if (localEmoticon.height == 0) {
        localEmoticon.height = j;
      }
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        localEmoticon.jobType = 2;
        localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      localEmoticon.height = j;
      paramQQAppInterface.h = paramMarkFaceMessage.cSubType;
      return paramQQAppInterface;
    }
    paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.a());
    paramQQAppInterface.b = 6;
    localEmoticon = new Emoticon();
    if (paramMarkFaceMessage.mediaType == 1) {
      localEmoticon.isSound = true;
    }
    for (;;)
    {
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        localEmoticon.jobType = 2;
        localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      localEmoticon.epId = str2;
      localEmoticon.eId = str1;
      localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
      localEmoticon.width = i;
      localEmoticon.height = j;
      localEmoticon.name = paramMarkFaceMessage.faceName;
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
      paramQQAppInterface.h = paramMarkFaceMessage.cSubType;
      return paramQQAppInterface;
      if (paramMarkFaceMessage.mediaType == 2) {
        localEmoticon.jobType = 1;
      }
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    paramAppInterface = new File(paramAppInterface.getApplication().getFilesDir() + "/recommend_magic_emotion_" + paramAppInterface.a() + ".json");
    if (paramAppInterface.exists())
    {
      paramAppInterface = FileUtils.a(paramAppInterface);
      try
      {
        paramAppInterface = new String(paramAppInterface, "UTF-8");
        return paramAppInterface;
      }
      catch (UnsupportedEncodingException paramAppInterface)
      {
        return null;
      }
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_emoticon_" + paramQQAppInterface.a() + ".dat");
    byte[] arrayOfByte;
    if (paramQQAppInterface.exists())
    {
      arrayOfByte = FileUtils.a(paramQQAppInterface);
      paramQQAppInterface = new EmosmPb.SubCmd0x5RspBQRecommend();
    }
    try
    {
      paramQQAppInterface.mergeFrom(arrayOfByte);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
    }
    return paramQQAppInterface.str_morebq_img_url.get();
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_emoticon_" + paramQQAppInterface.a() + ".dat");
    byte[] arrayOfByte;
    if (paramQQAppInterface.exists())
    {
      arrayOfByte = FileUtils.a(paramQQAppInterface);
      paramQQAppInterface = new EmosmPb.SubCmd0x5RspBQRecommend();
    }
    try
    {
      paramQQAppInterface.mergeFrom(arrayOfByte);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
    }
    return paramQQAppInterface.st_tab_info.get();
  }
  
  public static List a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(12);
    if (localList != null)
    {
      int i = localList.size() - 1;
      if (i >= 0)
      {
        RecentEmotionData localRecentEmotionData = (RecentEmotionData)localList.get(i);
        Object localObject;
        if (localRecentEmotionData.type == 4)
        {
          localObject = new EmojiEmoticonInfo();
          ((EmojiEmoticonInfo)localObject).b = 2;
          ((EmojiEmoticonInfo)localObject).jdField_a_of_type_Int = localRecentEmotionData.emoIndex;
          localArrayList.add(localObject);
        }
        for (;;)
        {
          i -= 1;
          break;
          if (localRecentEmotionData.type == 0)
          {
            localObject = new SystemEmoticonInfo();
            ((SystemEmoticonInfo)localObject).b = 1;
            ((SystemEmoticonInfo)localObject).jdField_a_of_type_Int = localRecentEmotionData.emoIndex;
            localArrayList.add(localObject);
          }
          else if ((localRecentEmotionData.type == 5) && (d(paramInt)))
          {
            localObject = new PicEmoticonInfo(paramQQAppInterface.a());
            ((PicEmoticonInfo)localObject).b = 6;
            String str = localRecentEmotionData.emoPath;
            ((PicEmoticonInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticonManager.a(String.valueOf(localRecentEmotionData.emoIndex), str);
            localArrayList.add(localObject);
          }
          else if (localRecentEmotionData.type == 3)
          {
            localObject = new FavoriteEmoticonInfo();
            ((FavoriteEmoticonInfo)localObject).b = 5;
            ((FavoriteEmoticonInfo)localObject).h = localRecentEmotionData.emoPath;
            localArrayList.add(localObject);
          }
        }
      }
    }
    localEntityManager.a();
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, EmoticonCallback paramEmoticonCallback)
  {
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(new FavPanelViewBinder(paramQQAppInterface, paramContext, paramInt, paramEmoticonCallback, 0));
    localArrayList.add(new ClassicEmoticonPanelViewBinder(paramContext, paramEmoticonCallback, 9));
    List localList = ((EmoticonManager)paramQQAppInterface.getManager(12)).b();
    Object localObject;
    EmoticonPackage localEmoticonPackage1;
    if (localList != null)
    {
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage1 = (EmoticonPackage)((Iterator)localObject).next();
        if ((!"100000".equals(localEmoticonPackage1.epId)) && (localEmoticonPackage1.type != 1) && (3 != localEmoticonPackage1.jobType) && ((localEmoticonPackage1.epId.equals("10278")) || (localEmoticonPackage1.epId.equals("10548")) || (localEmoticonPackage1.epId.equals("10335")) || (localEmoticonPackage1.epId.equals("10475")) || (localEmoticonPackage1.epId.equals("10020")) || (localEmoticonPackage1.epId.equals("10188")) || (localEmoticonPackage1.epId.equals("10326")))) {
          localArrayList.add(new BigEmoticonViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0, localEmoticonPackage1));
        }
      }
      localObject = a(paramQQAppInterface.getApplication().getSharedPreferences("mobileQQi", 0).getString("emosm_recommend_tab_json_s", ""));
      if (localObject != null) {
        localObject = ((List)localObject).iterator();
      }
    }
    label421:
    label422:
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage1 = (EmoticonPackage)((Iterator)localObject).next();
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        label329:
        if (localIterator.hasNext())
        {
          EmoticonPackage localEmoticonPackage2 = (EmoticonPackage)localIterator.next();
          if (!localEmoticonPackage1.epId.equalsIgnoreCase(localEmoticonPackage2.epId)) {
            break label421;
          }
          localEmoticonPackage2.isRecommendation = true;
          paramInt = 1;
        }
      }
      for (;;)
      {
        break label329;
        if (paramInt != 0) {
          break label422;
        }
        localEmoticonPackage1.isRecommendation = true;
        localEmoticonPackage1.valid = true;
        localArrayList.add(new BigEmoticonViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0, localEmoticonPackage1));
        break;
        return localArrayList;
      }
    }
  }
  
  public static List a(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((EmoticonManager)paramQQAppInterface.getManager(12)).b();
    Object localObject = b(paramQQAppInterface);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localArrayList.add(new RecommendEmoticonViewBinder(paramQQAppInterface, paramContext, 0));
    }
    localArrayList.add(new MagicFaceViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0));
    EmoticonPackage localEmoticonPackage1;
    if (localList != null)
    {
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage1 = (EmoticonPackage)((Iterator)localObject).next();
        if ((!"100000".equals(localEmoticonPackage1.epId)) && (localEmoticonPackage1.type != 1) && (3 != localEmoticonPackage1.jobType)) {
          localArrayList.add(new BigEmoticonViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0, localEmoticonPackage1));
        }
      }
      localObject = a(paramQQAppInterface.getApplication().getSharedPreferences("mobileQQi", 0).getString("emosm_recommend_tab_json_s", ""));
      if (localObject != null) {
        localObject = ((List)localObject).iterator();
      }
    }
    label358:
    label359:
    for (;;)
    {
      int i;
      if (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage1 = (EmoticonPackage)((Iterator)localObject).next();
        Iterator localIterator = localList.iterator();
        i = 0;
        label249:
        if (localIterator.hasNext())
        {
          EmoticonPackage localEmoticonPackage2 = (EmoticonPackage)localIterator.next();
          if (!localEmoticonPackage1.epId.equalsIgnoreCase(localEmoticonPackage2.epId)) {
            break label358;
          }
          localEmoticonPackage2.isRecommendation = true;
          i = 1;
        }
      }
      for (;;)
      {
        break label249;
        if (i != 0) {
          break label359;
        }
        localEmoticonPackage1.isRecommendation = true;
        localEmoticonPackage1.valid = true;
        localArrayList.add(new BigEmoticonViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0, localEmoticonPackage1));
        break;
        localArrayList.add(new ActionTabViewBinder(101));
        return localArrayList;
      }
    }
  }
  
  /* Error */
  public static List a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: ifnull +119 -> 125
    //   9: new 1907	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 1908	java/util/ArrayList:<init>	()V
    //   16: astore_0
    //   17: new 2073	org/json/JSONArray
    //   20: dup
    //   21: ldc_w 2075
    //   24: invokespecial 2076	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 2079	org/json/JSONArray:length	()I
    //   32: istore_2
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_1
    //   36: iload_2
    //   37: if_icmpge +86 -> 123
    //   40: new 2000	com/tencent/mobileqq/data/EmoticonPackage
    //   43: dup
    //   44: invokespecial 2080	com/tencent/mobileqq/data/EmoticonPackage:<init>	()V
    //   47: astore 4
    //   49: aload_3
    //   50: iload_1
    //   51: invokevirtual 2081	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   54: checkcast 1683	org/json/JSONObject
    //   57: astore 5
    //   59: aload 5
    //   61: ldc_w 2082
    //   64: invokevirtual 2085	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   67: ifeq +16 -> 83
    //   70: aload 4
    //   72: aload 5
    //   74: ldc_w 2082
    //   77: invokevirtual 1698	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: putfield 2086	com/tencent/mobileqq/data/EmoticonPackage:name	Ljava/lang/String;
    //   83: aload 5
    //   85: ldc_w 2088
    //   88: invokevirtual 2085	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   91: ifeq +16 -> 107
    //   94: aload 4
    //   96: aload 5
    //   98: ldc_w 2088
    //   101: invokevirtual 1698	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: putfield 2003	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   107: aload_0
    //   108: aload 4
    //   110: invokeinterface 1949 2 0
    //   115: pop
    //   116: iload_1
    //   117: iconst_1
    //   118: iadd
    //   119: istore_1
    //   120: goto -85 -> 35
    //   123: aload_0
    //   124: astore_3
    //   125: aload_3
    //   126: areturn
    //   127: astore_3
    //   128: aload 4
    //   130: astore_0
    //   131: aload_3
    //   132: invokevirtual 2089	java/lang/Exception:printStackTrace	()V
    //   135: aload_0
    //   136: areturn
    //   137: astore_3
    //   138: goto -7 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   34	86	1	i	int
    //   32	6	2	j	int
    //   4	122	3	localObject	Object
    //   127	5	3	localException1	Exception
    //   137	1	3	localException2	Exception
    //   1	128	4	localEmoticonPackage	EmoticonPackage
    //   57	40	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	17	127	java/lang/Exception
    //   17	33	137	java/lang/Exception
    //   40	83	137	java/lang/Exception
    //   83	107	137	java/lang/Exception
    //   107	116	137	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_emoticon_" + paramQQAppInterface.a() + ".dat");
    if (paramQQAppInterface.exists()) {
      paramQQAppInterface.delete();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    FileUtils.a(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_magic_emotion_" + paramQQAppInterface.a() + ".json", paramArrayOfByte, false);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = RecentEmotionData.class.getSimpleName();
    paramString = "delete from " + str + " where emoIndex = " + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonUtils", 2, paramString);
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    boolean bool = paramQQAppInterface.b(paramString);
    paramQQAppInterface.a();
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    return FileUtils.a(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_emoticon_" + paramQQAppInterface.a() + ".dat", paramArrayOfByte, false);
  }
  
  public static boolean a(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && (paramEmoticonPackage.status == 2) && ((paramEmoticonPackage.updateFlag & 0x1) == 1);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      if (paramString.length() > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder(paramString);
        int i = 0;
        while (i < localStringBuilder.length())
        {
          if (paramString.charAt(i) == '\024') {
            return true;
          }
          int j = localStringBuilder.codePointAt(i);
          if ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)) != null)
          {
            if (j > 65535) {}
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static List b(QQAppInterface paramQQAppInterface)
  {
    List localList = a(paramQQAppInterface);
    paramQQAppInterface = ((EmoticonManager)paramQQAppInterface.getManager(12)).b();
    if (paramQQAppInterface == null) {
      return localList;
    }
    if (localList != null)
    {
      int k = paramQQAppInterface.size();
      int i = 0;
      if (i < k)
      {
        int m = localList.size();
        int j = 0;
        for (;;)
        {
          EmoticonPackage localEmoticonPackage;
          EmosmPb.STRecommendTabInfo localSTRecommendTabInfo;
          if (j < m)
          {
            localEmoticonPackage = (EmoticonPackage)paramQQAppInterface.get(i);
            localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)localList.get(j);
            if ((localEmoticonPackage.jobType != 2) || (!localEmoticonPackage.kinId.equals(String.valueOf(localSTRecommendTabInfo.u32_tab_id.get())))) {
              break label136;
            }
            localList.remove(j);
          }
          for (;;)
          {
            i += 1;
            break;
            label136:
            if (!localEmoticonPackage.epId.equals(String.valueOf(localSTRecommendTabInfo.u32_tab_id.get()))) {
              break label170;
            }
            localList.remove(j);
          }
          label170:
          j += 1;
        }
      }
    }
    return localList;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = a(paramQQAppInterface.getApplication().getSharedPreferences("mobileQQi", 0).getString("emosm_recommend_tab_json_s", ""));
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext()) {
        if (paramString.equals(((EmoticonPackage)paramQQAppInterface.next()).epId)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return Pattern.compile("\\s").matcher(paramString).find();
  }
  
  public static List c(QQAppInterface paramQQAppInterface)
  {
    localObject = null;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new JSONObject(paramQQAppInterface).getJSONArray("rec");
        localArrayList = new ArrayList(paramQQAppInterface.length());
        j = 0;
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        JSONObject localJSONObject;
        int i;
        paramQQAppInterface.printStackTrace();
        return localObject;
      }
      try
      {
        if (j >= paramQQAppInterface.length()) {
          continue;
        }
        localObject = new EmoticonPackage();
        localJSONObject = paramQQAppInterface.getJSONObject(j);
        if ((!localJSONObject.has("packageId")) || (!localJSONObject.has("name")) || (!localJSONObject.has("label")) || (!localJSONObject.has("idlist"))) {
          continue;
        }
        ((EmoticonPackage)localObject).epId = localJSONObject.getString("packageId");
        ((EmoticonPackage)localObject).name = localJSONObject.getString("name");
        ((EmoticonPackage)localObject).upperLeftLable = Integer.parseInt(localJSONObject.getString("label"));
        ((EmoticonPackage)localObject).firstEmotionId = localJSONObject.getString("idlist").split(",")[0];
        ((EmoticonPackage)localObject).type = 1;
        k = 0;
        i = 0;
      }
      catch (Exception paramQQAppInterface)
      {
        localObject = localArrayList;
        continue;
        k += 1;
        continue;
      }
      if (k < localArrayList.size())
      {
        if (((EmoticonPackage)localArrayList.get(k)).epId != ((EmoticonPackage)localObject).epId) {
          break label263;
        }
        i = 1;
        break label263;
      }
      if (i == 0) {
        localArrayList.add(localObject);
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x4) == 4;
  }
  
  public static boolean c(String paramString)
  {
    return paramString.matches("^\\s*$");
  }
  
  public static List d(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(12);
    localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(12);
    Object localObject2 = c(paramQQAppInterface);
    Object localObject3 = localEmoticonManager.b();
    Object localObject1 = new ArrayList();
    Object localObject4;
    if (localObject3 != null)
    {
      int i = 0;
      while (i < ((List)localObject3).size())
      {
        localObject4 = (EmoticonPackage)((List)localObject3).get(i);
        if ((3 != ((EmoticonPackage)localObject4).jobType) || ("100000".equals(((EmoticonPackage)localObject4).epId)))
        {
          i += 1;
        }
        else
        {
          int j;
          if (localObject2 != null) {
            j = 0;
          }
          for (;;)
          {
            if (j < ((List)localObject2).size())
            {
              if (((EmoticonPackage)((List)localObject2).get(j)).epId.equals(((EmoticonPackage)localObject4).epId)) {
                ((List)localObject2).remove(j);
              }
            }
            else
            {
              ((List)localObject1).add(localObject4);
              break;
            }
            j += 1;
          }
        }
      }
    }
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EmoticonPackage)((Iterator)localObject2).next();
        localObject4 = new PicEmoticonInfo(paramQQAppInterface.a());
        ((PicEmoticonInfo)localObject4).b = 9;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon = new Emoticon();
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon.name = ((EmoticonPackage)localObject3).name;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId = ((EmoticonPackage)localObject3).epId;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId = ((EmoticonPackage)localObject3).firstEmotionId;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType = 2;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_Boolean = true;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_Int = ((EmoticonPackage)localObject3).upperLeftLable;
        localArrayList.add(localObject4);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonPackage)((Iterator)localObject1).next();
      localObject3 = localEmoticonManager.a(((EmoticonPackage)localObject2).epId);
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Emoticon)((Iterator)localObject3).next();
          ((Emoticon)localObject4).jobType = 2;
          ((Emoticon)localObject4).name = ((EmoticonPackage)localObject2).name;
          ((Emoticon)localObject4).value = ((EmoticonPackage)localObject2).valid;
          PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(paramQQAppInterface.a());
          localPicEmoticonInfo.b = 9;
          localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((Emoticon)localObject4);
          localArrayList.add(localPicEmoticonInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonUtils
 * JD-Core Version:    0.7.0.1
 */