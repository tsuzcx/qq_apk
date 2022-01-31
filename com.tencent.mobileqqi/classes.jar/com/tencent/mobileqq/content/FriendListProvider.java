package com.tencent.mobileqq.content;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.FriendMore;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppContentProvider;

public class FriendListProvider
  extends AppContentProvider
  implements FriendList
{
  public static final int a = 1000;
  public static final int b = 1001;
  public static final int c = 1002;
  public static final int d = 1003;
  public static final int e = 1004;
  public static final int f = 1005;
  public static final int g = 1006;
  public static final String p = "FriendListProvider";
  private final UriMatcher a = new UriMatcher(-1);
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.a.addURI("qqi.friendlist", "group/#", 1000);
    this.a.addURI("qqi.friendlist", "friendlist/#", 1001);
    this.a.addURI("qqi.friendlist", "trooplist/#", 1002);
    this.a.addURI("qqi.friendlist", "troopmemberinfo/#/#/#", 1003);
    this.a.addURI("qqi.friendlist", "troopname/#", 1004);
    this.a.addURI("qqi.friendlist", "discussinfo/#/#", 1005);
    this.a.addURI("qqi.friendlist", "discussmenberinfo/#/#/#", 1006);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i = this.a.match(paramUri);
    paramArrayOfString1 = (String)paramUri.getPathSegments().get(1);
    QQAppInterface localQQAppInterface = (QQAppInterface)getRuntime(paramArrayOfString1);
    if (localQQAppInterface == null)
    {
      paramString1 = null;
      return paramString1;
    }
    SQLiteDatabase localSQLiteDatabase = localQQAppInterface.b(paramArrayOfString1);
    if (localSQLiteDatabase == null) {
      return null;
    }
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FriendListProvider", 2, "Uri match missing! match: " + paramUri);
      }
    case 1000: 
      for (paramArrayOfString1 = null;; paramArrayOfString1 = localSQLiteDatabase.a(new Groups().getTableName(), new String[] { "group_name", "group_online_friend_count", "group_friend_count", "group_id", "seqid" }, paramString1, paramArrayOfString2, paramString2, null))
      {
        paramString1 = paramArrayOfString1;
        if (paramArrayOfString1 == null) {
          break;
        }
        paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
        return paramArrayOfString1;
      }
    case 1001: 
      label137:
      if ((paramString1 != null) && (paramString1.contains("@limit")))
      {
        i = paramString1.indexOf("@limit");
        paramArrayOfString1 = paramString1.substring(0, i).trim();
      }
      break;
    }
    for (paramString1 = " " + paramString1.substring(i + 1);; paramString1 = localQQAppInterface)
    {
      if ((paramArrayOfString1 != null) && (paramArrayOfString1.length() > 0) && (paramArrayOfString2 != null))
      {
        int j = paramArrayOfString2.length;
        i = 0;
        while (i < j)
        {
          paramArrayOfString1 = paramArrayOfString1.replaceFirst("\\?", paramArrayOfString2[i]);
          i += 1;
        }
      }
      for (paramArrayOfString1 = " where " + paramArrayOfString1;; paramArrayOfString1 = "")
      {
        paramArrayOfString2 = "select f.*, m.signature, v.flags from " + new Friends().getTableName() + " f left join " + new FriendMore().getTableName() + " m on f.uin=m.uin left join " + new Ability().getTableName() + " v on m.uin=v.uin " + paramArrayOfString1 + " order by " + paramString2;
        paramArrayOfString1 = paramArrayOfString2;
        if (paramString1 != null) {
          paramArrayOfString1 = paramArrayOfString2 + paramString1;
        }
        paramArrayOfString1 = localSQLiteDatabase.a(paramArrayOfString1, null);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("query", 2, getClass().getName() + " MATCH_TROOP_LIST");
      }
      paramArrayOfString1 = localSQLiteDatabase.a("select ti._id,ti.troopuin,ti.troopname,ti.troopmemo from TroopInfo ti", null);
      break label137;
      paramArrayOfString1 = paramUri.getPathSegments();
      if (paramArrayOfString1.size() < 4) {
        break;
      }
      paramArrayOfString1 = localSQLiteDatabase.a(new TroopMemberInfo().getTableName(), null, "troopuin=? AND memberuin=?", new String[] { (String)paramArrayOfString1.get(2), (String)paramArrayOfString1.get(3) }, null, null);
      break label137;
      paramString1 = paramUri.getPathSegments();
      if (paramString1.size() < 2) {
        break;
      }
      paramArrayOfString1 = new TroopInfo().getTableName();
      paramString1 = (String)paramString1.get(1);
      paramArrayOfString1 = localSQLiteDatabase.a(paramArrayOfString1, new String[] { "troopname" }, "troopuin=?", new String[] { paramString1 }, paramString2, null);
      break label137;
      paramArrayOfString1 = paramUri.getPathSegments();
      if (paramArrayOfString1.size() < 3) {
        break;
      }
      paramArrayOfString1 = localSQLiteDatabase.a(new DiscussionInfo().getTableName(), null, "uin=?", new String[] { (String)paramArrayOfString1.get(2) }, null, null);
      break label137;
      paramArrayOfString1 = paramUri.getPathSegments();
      if (paramArrayOfString1.size() < 4) {
        break;
      }
      paramArrayOfString1 = localSQLiteDatabase.a(new DiscussionMemberInfo().getTableName(), null, "discussionUin=? AND memberUin=?", new String[] { (String)paramArrayOfString1.get(2), (String)paramArrayOfString1.get(3) }, null, null);
      break label137;
      localQQAppInterface = null;
      paramArrayOfString1 = paramString1;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.content.FriendListProvider
 * JD-Core Version:    0.7.0.1
 */