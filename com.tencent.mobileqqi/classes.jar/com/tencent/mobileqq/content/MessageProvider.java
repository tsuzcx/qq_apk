package com.tencent.mobileqq.content;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppContentProvider;

public class MessageProvider
  extends AppContentProvider
  implements Message
{
  public static final int a = 1000;
  public static final int b = 1001;
  public static final int c = 1002;
  public static final int d = 1003;
  public static final String d = "MessageProvider";
  public static final int e = 1004;
  private final UriMatcher a;
  public SQLiteDatabase a;
  private String e;
  
  public MessageProvider()
  {
    this.jdField_a_of_type_AndroidContentUriMatcher = new UriMatcher(-1);
  }
  
  private String a(String paramString)
  {
    String[] arrayOfString = paramString.split("/", 4);
    if (arrayOfString.length > 2)
    {
      if (arrayOfString[2].equals("friend")) {
        paramString = MessageRecord.getTableName(arrayOfString[3], 0);
      }
      for (;;)
      {
        this.e = arrayOfString[1];
        return paramString;
        if (arrayOfString[2].equals("troop")) {
          paramString = MessageRecord.getTableName(arrayOfString[3], 1);
        } else if (arrayOfString[2].equals("discussion")) {
          paramString = MessageRecord.getTableName(arrayOfString[3], 3000);
        } else {
          paramString = arrayOfString[2];
        }
      }
    }
    return "";
  }
  
  private String b(String paramString)
  {
    String[] arrayOfString = paramString.split("/", 4);
    if (arrayOfString.length > 2)
    {
      if (arrayOfString[2].equals("friend_local_history")) {
        paramString = MessageRecord.getTableName(arrayOfString[3], 0);
      }
      for (;;)
      {
        this.e = arrayOfString[1];
        return paramString;
        if (arrayOfString[2].equals("troop_local_history")) {
          paramString = MessageRecord.getTableName(arrayOfString[3], 1);
        } else if (arrayOfString[2].equals("discussion_local_history")) {
          paramString = MessageRecord.getTableName(arrayOfString[3], 3000);
        } else {
          paramString = arrayOfString[2];
        }
      }
    }
    return "";
  }
  
  private String c(String paramString)
  {
    String[] arrayOfString = paramString.split("/", 4);
    if (arrayOfString.length > 2)
    {
      if (arrayOfString[2].equals("friend_local_history")) {
        paramString = MessageRecord.getOldTableName(arrayOfString[3], 0);
      }
      for (;;)
      {
        this.e = arrayOfString[1];
        return paramString;
        if (arrayOfString[2].equals("troop_local_history")) {
          paramString = MessageRecord.getOldTableName(arrayOfString[3], 1);
        } else if (arrayOfString[2].equals("discussion_local_history")) {
          paramString = MessageRecord.getOldTableName(arrayOfString[3], 3000);
        } else {
          paramString = arrayOfString[2];
        }
      }
    }
    return "";
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri);
    paramUri = a(paramUri.getPath());
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri, paramString, paramArrayOfString);
      continue;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri, paramString, paramArrayOfString);
      }
      catch (Exception paramUri) {}
    }
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
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/friend/*", 1000);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/troop/*", 1000);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/grp/*", 1000);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/discussion/*", 1000);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/friend_local_history/*", 1004);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/troop_local_history/*", 1004);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/grp_local_history/*", 1004);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/discussion_local_history/*", 1004);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/RecentUser", 1001);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/RecentMsg", 1002);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qqi.message", "#/msgTemp/*", 1003);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    String str2 = null;
    Object localObject1 = null;
    int i = this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri);
    String str3 = (String)paramUri.getPathSegments().get(0);
    QQAppInterface localQQAppInterface = (QQAppInterface)getRuntime(str3);
    if (localQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageProvider", 2, "MessageProvide getApp null!  :" + paramUri);
      }
    }
    do
    {
      return null;
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = localQQAppInterface.b(str3);
      if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("MessageProvider", 2, "MessageProvide getDB null!  :" + paramUri);
    return null;
    switch (i)
    {
    case 1002: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("MessageProvider", 2, "MessageProvide match -1!  :" + paramUri);
      }
      paramUri = null;
    }
    for (;;)
    {
      return paramUri;
      str2 = a(paramUri.getPath());
      if ((paramString1 != null) && (paramString1.contains("@limit"))) {
        paramUri = paramString1.substring(0, paramString1.indexOf("@limit")).trim();
      }
      for (paramString1 = paramString1.substring(paramString1.indexOf("@limit") + "@limit".length());; paramString1 = (String)localObject1)
      {
        paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str2, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
        break;
        paramUri = paramString1;
      }
      str3 = a(paramUri.getPath());
      if ((paramString1 != null) && (paramString1.contains("@limit")))
      {
        paramUri = paramString1.substring(0, paramString1.indexOf("@limit")).trim();
        paramString1 = paramString1.substring(paramString1.indexOf("@limit") + "@limit".length());
      }
      for (;;)
      {
        for (;;)
        {
          if (str3.indexOf("mr_troop_") == -1) {
            break label522;
          }
          if (paramArrayOfString1 != null)
          {
            return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str3, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
            paramUri = paramString1;
            paramString1 = str2;
          }
          else
          {
            localObject1 = new StringBuilder("select * from ");
            ((StringBuilder)localObject1).append(str3);
            ((StringBuilder)localObject1).append(" t left join TroopMemberInfo m on t.senderuin=m.memberuin and t.frienduin=m.troopuin");
            if ((paramUri != null) && (paramUri.length() > 0))
            {
              ((StringBuilder)localObject1).append(" where ");
              ((StringBuilder)localObject1).append(paramUri);
            }
            if ((paramString2 != null) && (paramString2.length() > 0))
            {
              ((StringBuilder)localObject1).append(" order by ");
              ((StringBuilder)localObject1).append(paramString2);
            }
            ((StringBuilder)localObject1).append(" limit ");
            ((StringBuilder)localObject1).append(paramString1);
            try
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(((StringBuilder)localObject1).toString(), paramArrayOfString2);
              paramUri = (Uri)localObject1;
            }
            catch (SQLException localSQLException1)
            {
              paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str3, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
            }
          }
        }
        break;
      }
      label522:
      if (str3.indexOf("mr_grp_") != -1)
      {
        if (paramArrayOfString1 != null) {
          return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str3, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
        }
        Object localObject2 = new StringBuilder("select * from ");
        ((StringBuilder)localObject2).append(str3);
        ((StringBuilder)localObject2).append(" t left join GrpMemberInfo m on t.senderuin=m.mId and t.frienduin=m.grpID left join friends l on m.mId =l.uin ");
        if ((paramUri != null) && (paramUri.length() > 0))
        {
          ((StringBuilder)localObject2).append(" where ");
          ((StringBuilder)localObject2).append(paramUri);
        }
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          ((StringBuilder)localObject2).append(" order by ");
          ((StringBuilder)localObject2).append(paramString2);
        }
        ((StringBuilder)localObject2).append(" limit ");
        ((StringBuilder)localObject2).append(paramString1);
        try
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(((StringBuilder)localObject2).toString(), paramArrayOfString2);
          paramArrayOfString1 = (String[])localObject2;
        }
        catch (SQLException localSQLException2)
        {
          for (;;)
          {
            paramArrayOfString1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str3, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
          }
        }
        paramUri = paramArrayOfString1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("gene", 2, "cursor: " + paramArrayOfString1);
        paramUri = paramArrayOfString1;
        continue;
      }
      if (str3.indexOf("mr_discusssion_") != -1)
      {
        if (paramArrayOfString1 != null) {
          return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str3, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
        }
        Object localObject3 = new StringBuilder("select * from ");
        ((StringBuilder)localObject3).append(str3);
        ((StringBuilder)localObject3).append(" t left join DiscussionMemberInfo m on t.senderuin=m.memberUin and t.frienduin=m.discussionUin");
        if ((paramUri != null) && (paramUri.length() > 0))
        {
          ((StringBuilder)localObject3).append(" where ");
          ((StringBuilder)localObject3).append(paramUri);
        }
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          ((StringBuilder)localObject3).append(" order by ");
          ((StringBuilder)localObject3).append(paramString2);
        }
        ((StringBuilder)localObject3).append(" limit ");
        ((StringBuilder)localObject3).append(paramString1);
        try
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(((StringBuilder)localObject3).toString(), paramArrayOfString2);
          paramUri = (Uri)localObject3;
        }
        catch (SQLException localSQLException3)
        {
          paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str3, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
        }
      }
      else
      {
        if (paramArrayOfString1 != null) {
          return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str3, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
        }
        Object localObject4 = new StringBuilder("select * from ");
        ((StringBuilder)localObject4).append(str3);
        ((StringBuilder)localObject4).append(" t left join Friends f on t.senderuin=f.uin");
        if ((paramUri != null) && (paramUri.length() > 0))
        {
          ((StringBuilder)localObject4).append(" where ");
          ((StringBuilder)localObject4).append(paramUri);
        }
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          ((StringBuilder)localObject4).append(" order by ");
          ((StringBuilder)localObject4).append(paramString2);
        }
        ((StringBuilder)localObject4).append(" limit ");
        ((StringBuilder)localObject4).append(paramString1);
        try
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(((StringBuilder)localObject4).toString(), paramArrayOfString2);
          paramUri = (Uri)localObject4;
        }
        catch (SQLException localSQLException4)
        {
          paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str3, paramArrayOfString1, paramUri, paramArrayOfString2, paramString2, paramString1);
        }
        continue;
        String str1 = b(paramUri.getPath());
        paramUri = c(paramUri.getPath());
        if (str1.indexOf("mr_troop_") != -1)
        {
          if (paramArrayOfString1 != null) {
            return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str1, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
          }
          paramUri = MessageDBUtils.a(paramUri, str1, this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase);
          if (paramUri == null) {
            break;
          }
          paramUri.append(" t left join TroopMemberInfo m on t.senderuin=m.memberuin and t.frienduin=m.troopuin");
          if ((paramString1 != null) && (paramString1.length() > 0))
          {
            paramUri.append(" where ");
            paramUri.append(paramString1);
          }
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            paramUri.append(" order by ");
            paramUri.append(paramString2);
          }
          try
          {
            paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri.toString(), paramArrayOfString2);
          }
          catch (SQLException paramUri)
          {
            paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str1, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
          }
          continue;
        }
        if (str1.indexOf("mr_grp_") != -1)
        {
          if (paramArrayOfString1 != null) {
            return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str1, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
          }
          paramUri = new StringBuilder("select * from ");
          paramUri.append(str1);
          paramUri.append(" t left join GrpMemberInfo m on t.senderuin=m.mId and t.frienduin=m.grpID left join friends l on m.mId =l.uin ");
          if ((paramString1 != null) && (paramString1.length() > 0))
          {
            paramUri.append(" where ");
            paramUri.append(paramString1);
          }
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            paramUri.append(" order by ");
            paramUri.append(paramString2);
          }
          try
          {
            paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri.toString(), paramArrayOfString2);
            paramArrayOfString1 = paramUri;
          }
          catch (SQLException paramUri)
          {
            for (;;)
            {
              paramArrayOfString1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str1, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
            }
          }
          paramUri = paramArrayOfString1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("gene", 2, "cursor: " + paramArrayOfString1);
          paramUri = paramArrayOfString1;
          continue;
        }
        if (str1.indexOf("mr_discusssion_") != -1)
        {
          if (paramArrayOfString1 != null) {
            return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str1, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
          }
          paramUri = MessageDBUtils.a(paramUri, str1, this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase);
          if (paramUri == null) {
            break;
          }
          paramUri.append(" t left join DiscussionMemberInfo m on t.senderuin=m.memberUin and t.frienduin=m.discussionUin");
          if ((paramString1 != null) && (paramString1.length() > 0))
          {
            paramUri.append(" where ");
            paramUri.append(paramString1);
          }
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            paramUri.append(" order by ");
            paramUri.append(paramString2);
          }
          try
          {
            paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri.toString(), paramArrayOfString2);
          }
          catch (SQLException paramUri)
          {
            paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str1, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
          }
          continue;
        }
        if (paramArrayOfString1 != null) {
          return this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str1, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
        }
        paramUri = MessageDBUtils.a(paramUri, str1, this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase, paramString1, paramString2);
        try
        {
          paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri.toString(), paramArrayOfString2);
        }
        catch (SQLException paramUri)
        {
          paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str1, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, null);
        }
        continue;
        try
        {
          a(paramUri.getPath());
          if (QLog.isColorLevel()) {
            QLog.d("query", 2, getClass().getName() + " MATCH_RECENT_LIST");
          }
          paramUri = new StringBuilder("select r._id,r.uin,r.type,f.name,f.faceid,f.status,f.isMqqOnLine,f.detalStatusFlag,f.sqqOnLineState,t.troopname,t.troopmemo, r.lastmsgtime, r.troopUin, di.faceUinSet, di.discussionName from ");
          paramUri.append(new RecentUser().getTableName());
          paramUri.append(" r left join friends f on r.uin = f.uin  left join troopinfo t on r.uin = t.troopuin left join DiscussionInfo di on r.uin = di.uin ");
          paramUri.append(" where ");
          paramUri.append(" f._id>0 ");
          if ((paramString1 != null) && (paramString1.length() > 0))
          {
            paramUri.append(" and ");
            paramUri.append(paramString1);
          }
          paramUri.append(" order by ");
          paramUri.append("r.lastmsgtime desc");
          paramUri = paramUri.toString();
          paramArrayOfString1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri, paramArrayOfString2);
        }
        catch (SQLException paramUri)
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.i("MessageProvider", 2, "cursor is queried: " + paramUri);
            }
            paramUri = paramArrayOfString1;
            if (paramArrayOfString1 == null) {
              continue;
            }
            paramUri = paramArrayOfString1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("MessageProvider", 2, "cursor.getCount() = " + paramArrayOfString1.getCount());
            paramUri = paramArrayOfString1;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramUri = paramArrayOfString1;
              paramArrayOfString1 = paramString1;
            }
          }
          paramUri = paramUri;
          if (QLog.isColorLevel()) {
            QLog.i("MessageProvider", 2, "crash in catch");
          }
          paramUri = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a("select r._id,r.uin,r.type,f.name,f.faceid,f.status,f.isMqqOnLine,f.detalStatusFlag,f.sqqOnLineState, t.troopname,t.troopmemo, r.lastmsgtime from recentuser r left join friends f on r.uin = f.uin left join troopinfo t on r.uin = t.troopuin   order by r.lastmsgtime desc", null);
        }
        catch (Exception paramArrayOfString1)
        {
          paramUri = null;
        }
        paramArrayOfString1.printStackTrace();
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    switch (this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri))
    {
    }
    do
    {
      do
      {
        i = 0;
        int j;
        do
        {
          return i;
          paramUri = a(paramUri.getPath());
          j = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri, paramContentValues, paramString, paramArrayOfString);
          i = j;
        } while (j <= 0);
        getContext().getContentResolver().notifyChange(Message.a, null);
        return j;
        paramUri = a(paramUri.getPath());
        localObject = (QQAppInterface)getRuntime(this.e);
      } while (localObject == null);
      localObject = ((QQAppInterface)localObject).a().a().a();
    } while (localObject == null);
    Object localObject = ((List)localObject).iterator();
    int i = 0;
    RecentUser localRecentUser;
    if (((Iterator)localObject).hasNext())
    {
      localRecentUser = (RecentUser)((Iterator)localObject).next();
      if ((localRecentUser.type == 0) || (localRecentUser.type == 1001)) {
        paramUri = MessageRecord.getTableName(localRecentUser.uin, 0);
      }
    }
    for (;;)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramUri, paramContentValues, paramString, paramArrayOfString) + i;
      break;
      if (localRecentUser.type == 1)
      {
        paramUri = MessageRecord.getTableName(localRecentUser.uin, 1);
        continue;
        getContext().getContentResolver().notifyChange(Message.a, null);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.content.MessageProvider
 * JD-Core Version:    0.7.0.1
 */