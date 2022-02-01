import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aeba
{
  private aebo b;
  private QQAppInterface mApp;
  
  public aeba() {}
  
  public aeba(aebo paramaebo)
  {
    this.b = paramaebo;
  }
  
  public aeba(QQAppInterface paramQQAppInterface, aebo paramaebo)
  {
    this(paramaebo);
    this.mApp = paramQQAppInterface;
  }
  
  public static Bundle a(int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramInt, paramString, paramBoolean, 0);
  }
  
  public static Bundle a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "updateColorNote~~~");
    }
    Bundle localBundle = new Bundle();
    Object localObject = String.valueOf(paramInt1) + paramString + paramInt2;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNote~~~ key " + (String)localObject);
      }
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = paramString.a().a().a((String)localObject);
      if (localObject != null)
      {
        if (paramBoolean)
        {
          paramInt1 = i;
          ((ColorNote)localObject).setState(paramInt1);
        }
      }
      else {
        if (localObject == null) {
          break label216;
        }
      }
      label216:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localBundle.putBoolean("extra_is_colornote_exists", paramBoolean);
        localBundle.putBoolean("extra_can_add_colornote", agj());
        localBundle.putBoolean("extra_after_sync_msg", aeee.Wn());
        localObject = aeee.a(paramString);
        localBundle.putInt("key_float_window_position_x", ((Point)localObject).x);
        localBundle.putInt("key_float_window_position_y", ((Point)localObject).y);
        aeee.e(paramString.getApp(), 3, true);
        return localBundle;
        paramInt1 = 1;
        break;
      }
    }
    paramString = new Bundle();
    paramString.putString("extra_unikey", (String)localObject);
    paramString.putBoolean("extra_update_colornote_state", paramBoolean);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote_state", paramString);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString != null) {
        break label320;
      }
    }
    label320:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return localBundle;
    }
  }
  
  private EIPCResult a(String paramString1, String paramString2, Bundle paramBundle)
  {
    paramString2 = QIPCClientHelper.getInstance().getClient().callServer(paramString1, paramString2, paramBundle);
    if (((paramString2 == null) || (paramString2.isSuccess())) && (QLog.isColorLevel()))
    {
      paramBundle = new StringBuilder().append("addColorNote eipcResult = ");
      if (paramString2 != null) {
        break label66;
      }
    }
    label66:
    for (paramString1 = "null";; paramString1 = Boolean.valueOf(paramString2.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString1);
      return paramString2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ProxyListener paramProxyListener)
  {
    aebe.ea(paramQQAppInterface.a().a().a(paramQQAppInterface.getCurrentAccountUin(), paramProxyListener));
  }
  
  public static boolean a(ColorNote paramColorNote)
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return b(paramColorNote);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("color_note_recently_viewed_comparator", paramColorNote);
    return QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_color_note", localBundle).isSuccess();
  }
  
  protected static boolean a(String paramString1, String paramString2, Object paramObject)
  {
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface.a().a().a(localQQAppInterface.getCurrentUin(), paramString1, paramString2, paramObject) != null) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNoteInner~~~ unikey " + paramString1 + ", result" + bool);
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  protected static boolean agj()
  {
    return (BaseApplicationImpl.sProcessId == 1) && (((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().canAddColorNote());
  }
  
  private boolean agk()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public static boolean b(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "isColorNoteExit~~~ serviceType = " + paramInt1 + ", subType = " + paramString);
    }
    paramString = String.valueOf(paramInt1) + paramString + paramInt2;
    Object localObject;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      localObject = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().r(false).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ColorNote)((Iterator)localObject).next()).getUniKey().equals(paramString));
    }
    for (bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "isColorNoteExit main ~~~ result = " + bool);
      }
      do
      {
        return bool;
        localObject = new Bundle();
        ((Bundle)localObject).putString("extra_unikey", paramString);
        paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_query_isexists", (Bundle)localObject);
        if ((paramString != null) && (paramString.isSuccess())) {
          return paramString.data.getBoolean("extra_is_colornote_exists", false);
        }
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("isColorNoteExit eipcResult = ");
      if (paramString == null) {}
      for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
      {
        QLog.d("ColorNoteHelper", 2, paramString);
        return false;
      }
    }
  }
  
  private static boolean b(ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aebo localaebo = localQQAppInterface.a().a();
    aeee.e(localQQAppInterface.getApp(), true, false);
    return localaebo.a(localQQAppInterface.getCurrentUin(), paramColorNote);
  }
  
  public static boolean c(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "deleteColorNote~~~");
    }
    paramString = String.valueOf(paramInt1) + paramString + paramInt2;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "deleteColorNote~~~ main key" + paramString);
      }
      ep(paramString, paramInt2);
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    ((Bundle)localObject).putInt("color_note_extra_type", paramInt2);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_delete_colornote", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getBoolean("extra_delete_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("deleteColorNote eipcResult = ");
      if (paramString != null) {
        break label192;
      }
    }
    label192:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return false;
    }
  }
  
  public static boolean canAddColorNote()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().canAddColorNote();
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_can_add_colornote", null);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("extra_can_add_colornote", true);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("deleteColorNote eipcResult = ");
      if (localObject != null) {
        break label107;
      }
    }
    label107:
    for (localObject = "null";; localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, localObject);
      return false;
    }
  }
  
  private boolean d(ColorNote paramColorNote)
  {
    if (this.mApp == null)
    {
      this.mApp = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      if (this.mApp == null)
      {
        QLog.e("ColorNoteHelper", 1, "app null");
        return false;
      }
    }
    Object localObject;
    if (this.b == null)
    {
      localObject = this.mApp.a();
      if (localObject != null) {
        this.b = ((ProxyManager)localObject).a();
      }
      if (this.b == null)
      {
        QLog.e("ColorNoteHelper", 1, "proxy null");
        return false;
      }
    }
    if (paramColorNote.mExtra == 2) {}
    for (int i = 1;; i = 0)
    {
      localObject = this.b;
      paramColorNote.animate = true;
      boolean bool1;
      if ((((aebo)localObject).canAddColorNote()) || (i != 0) || (paramColorNote.getServiceType() == 16973824))
      {
        bool1 = ((aebo)localObject).a(this.mApp.getCurrentUin(), paramColorNote, null, false);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ " + paramColorNote);
        }
        if (paramColorNote.mExtra != 2)
        {
          localObject = aqmj.c(BaseApplicationImpl.getContext(), this.mApp.getCurrentUin());
          boolean bool2 = ((SharedPreferences)localObject).getBoolean("color_note_permission_music", true);
          if (paramColorNote.mServiceType == 16973824)
          {
            i = 1;
            if ((i != 0) && (!bool2)) {
              break label297;
            }
          }
          label297:
          for (int j = 1;; j = 0)
          {
            if (j != 0)
            {
              aeee.a(this.mApp.getApp(), true, false, paramColorNote);
              if (i != 0) {
                ((SharedPreferences)localObject).edit().putBoolean("color_note_permission_music", false).apply();
              }
            }
            if (i != 0) {
              aeee.ee(BaseApplicationImpl.getContext());
            }
            return bool1;
            i = 0;
            break;
          }
        }
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ColorNoteHelper", 2, "addColorNoteInner~~~ fail cause count limit, maxCount = " + aebo.MAX_COUNT + " , currCount = " + ((aebo)localObject).Cf());
        return false;
      }
      return bool1;
    }
  }
  
  private boolean d(String paramString, List<ColorNote> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ColorNote)paramList.next()).getUniKey().equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  protected static void ep(String paramString, int paramInt)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = ((QQAppInterface)localObject2).a().a();
    paramString = ((aebo)localObject1).a(paramString, paramInt);
    if (paramString == null) {}
    do
    {
      return;
      ((aebo)localObject1).a(((QQAppInterface)localObject2).getCurrentUin(), paramString, null);
      aeee.e(((QQAppInterface)localObject2).getApp(), 3, false);
      localObject2 = paramString.getServiceType() + "";
      String str = paramString.getSubType();
      Intent localIntent = new Intent("key_delete_item_call");
      localIntent.putExtra("key_color_note_servicetype_list", new String[] { localObject2 });
      localIntent.putExtra("key_color_note_suptype_list", new String[] { str });
      localIntent.putExtra("extra_can_add_colornote", ((aebo)localObject1).canAddColorNote());
      localIntent.putExtras(paramString.parseBundle());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramString);
      aebe.ea((ArrayList)localObject1);
    } while ((paramString == null) || (paramString.getServiceType() != 16908290));
    nns.a(paramString);
  }
  
  public static boolean iZ(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      aedc.jc(paramInt);
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("color_note_service_type", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_history_color_notes", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("extra_clear_history_succ", false);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("clearHistoryNote eipcResult = ");
      if (localObject != null) {
        break label112;
      }
    }
    label112:
    for (localObject = "null";; localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, localObject);
      return false;
    }
  }
  
  public static boolean o(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "updateColorNote~~~");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "updateColorNote~~~ main[ uniKey = " + paramString1 + ", fieldName = " + paramString2 + ", fieldValue = " + paramString3 + "]");
      }
      return a(paramString1, paramString2, paramString3);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_unikey", paramString1);
    localBundle.putString("extra_field_name", paramString2);
    localBundle.putString("extra_field_value", paramString3);
    paramString1 = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote", localBundle);
    if ((paramString1 != null) && (paramString1.isSuccess())) {
      return paramString1.data.getBoolean("extra_update_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString1 != null) {
        break label198;
      }
    }
    label198:
    for (paramString1 = "null";; paramString1 = Boolean.valueOf(paramString1.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString1);
      return false;
    }
  }
  
  public static boolean v(int paramInt, String paramString)
  {
    return b(paramInt, paramString, 0);
  }
  
  public static boolean w(int paramInt, String paramString)
  {
    return c(paramInt, paramString, 0);
  }
  
  boolean V(String paramString, int paramInt)
  {
    if ((this.mApp == null) || (this.b == null) || (aqmr.isEmpty(paramString))) {}
    do
    {
      return false;
      paramString = this.b.a(paramString, paramInt);
    } while (paramString == null);
    this.b.a(this.mApp.getCurrentUin(), paramString, null);
    aeee.e(this.mApp.getApp(), 3, false);
    Object localObject = paramString.getServiceType() + "";
    String str = paramString.getSubType();
    Intent localIntent = new Intent("key_delete_item_call");
    localIntent.putExtra("key_color_note_servicetype_list", new String[] { localObject });
    localIntent.putExtra("key_color_note_suptype_list", new String[] { str });
    localIntent.putExtra("extra_can_add_colornote", this.b.canAddColorNote());
    localIntent.putExtras(paramString.parseBundle());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    aebe.ea((ArrayList)localObject);
    if ((paramString != null) && (paramString.getServiceType() == 16908290)) {
      nns.a(paramString);
    }
    return true;
  }
  
  public boolean W(String paramString, int paramInt)
  {
    if (agk())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHelper", 2, "deleteColorNote~~~ main key" + paramString);
      }
      V(paramString, paramInt);
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    ((Bundle)localObject).putInt("color_note_extra_type", paramInt);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_delete_colornote", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getBoolean("extra_delete_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("deleteColorNote eipcResult = ");
      if (paramString != null) {
        break label153;
      }
    }
    label153:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return false;
    }
  }
  
  public Bundle a(String paramString, boolean paramBoolean)
  {
    int i = 2;
    Bundle localBundle = new Bundle();
    if (agk())
    {
      if ((this.mApp == null) || (this.b == null)) {
        return null;
      }
      paramString = this.b.a(paramString);
      if (paramString != null)
      {
        if (paramBoolean) {
          paramString.setState(i);
        }
      }
      else {
        if (paramString == null) {
          break label141;
        }
      }
      label141:
      for (paramBoolean = true;; paramBoolean = false)
      {
        localBundle.putBoolean("extra_is_colornote_exists", paramBoolean);
        localBundle.putBoolean("extra_can_add_colornote", agl());
        localBundle.putBoolean("extra_after_sync_msg", aeee.Wn());
        paramString = aeee.a(this.mApp);
        localBundle.putInt("key_float_window_position_x", paramString.x);
        localBundle.putInt("key_float_window_position_y", paramString.y);
        aeee.e(this.mApp.getApp(), 3, true);
        return localBundle;
        i = 1;
        break;
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("extra_unikey", paramString);
    ((Bundle)localObject).putBoolean("extra_update_colornote_state", paramBoolean);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote_state", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString != null) {
        break label248;
      }
    }
    label248:
    for (paramString = "null";; paramString = Boolean.valueOf(paramString.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString);
      return localBundle;
    }
  }
  
  public void a(aebo paramaebo)
  {
    this.b = paramaebo;
  }
  
  public boolean agl()
  {
    if (agk()) {
      return this.b.canAddColorNote();
    }
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_can_add_colornote", null);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess())) {
      return ((EIPCResult)localObject).data.getBoolean("extra_can_add_colornote", true);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("deleteColorNote eipcResult = ");
      if (localObject != null) {
        break label96;
      }
    }
    label96:
    for (localObject = "null";; localObject = Boolean.valueOf(((EIPCResult)localObject).isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, localObject);
      return false;
    }
  }
  
  public boolean b(String paramString1, String paramString2, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.mApp != null)
    {
      if (this.b != null) {
        break label31;
      }
      bool2 = bool1;
    }
    label31:
    do
    {
      return bool2;
      bool1 = bool3;
      if (agk())
      {
        bool1 = bool3;
        if (this.b.a(this.mApp.getCurrentUin(), paramString1, paramString2, paramObject) != null) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteHelper", 2, "updateColorNoteInner~~~ unikey " + paramString1 + ", result" + bool1);
    return bool1;
  }
  
  boolean c(ColorNote paramColorNote)
  {
    if (this.b == null) {
      return false;
    }
    aeee.a(this.mApp.getApp(), true, false, paramColorNote);
    return this.b.a(this.mApp.getCurrentUin(), paramColorNote);
  }
  
  public boolean e(ColorNote paramColorNote)
  {
    if (agk()) {
      return c(paramColorNote);
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("color_note_recently_viewed_comparator", paramColorNote);
    return QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_clear_color_note", localBundle).isSuccess();
  }
  
  public boolean lq(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteHelper", 2, "start search. key: " + paramString);
    }
    if (agk())
    {
      if (this.b == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteHelper", 2, "ColorNoteProxy is null");
        }
        return false;
      }
      return d(paramString, this.b.r(false));
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_unikey", paramString);
    return a("ColorNoteIPCServer", "cmd_query_isexists", localBundle).data.getBoolean("extra_is_colornote_exists", false);
  }
  
  public boolean p(String paramString1, String paramString2, String paramString3)
  {
    if (agk()) {
      return b(paramString1, paramString2, paramString3);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_unikey", paramString1);
    localBundle.putString("extra_field_name", paramString2);
    localBundle.putString("extra_field_value", paramString3);
    paramString1 = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_update_colornote", localBundle);
    if ((paramString1 != null) && (paramString1.isSuccess())) {
      return paramString1.data.getBoolean("extra_update_colornote_succ", false);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("updateColorNote eipcResult = ");
      if (paramString1 != null) {
        break label132;
      }
    }
    label132:
    for (paramString1 = "null";; paramString1 = Boolean.valueOf(paramString1.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramString1);
      return false;
    }
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public boolean z(Bundle paramBundle)
  {
    if (agk()) {
      return d(new ColorNote(paramBundle));
    }
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("ColorNoteIPCServer", "cmd_add_colornote", paramBundle);
    if ((paramBundle != null) && (paramBundle.isSuccess())) {
      return paramBundle.data.getBoolean("extra_add_colornote_succ", false);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("addColorNote eipcResult = ");
      if (paramBundle != null) {
        break label101;
      }
    }
    label101:
    for (paramBundle = "null";; paramBundle = Boolean.valueOf(paramBundle.isSuccess()))
    {
      QLog.d("ColorNoteHelper", 2, paramBundle);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeba
 * JD-Core Version:    0.7.0.1
 */