import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class akvu
  extends OGAbstractDao
{
  public akvu()
  {
    this.columnLen = 24;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (ResourcePluginInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.strPkgName = paramCursor.getString(paramCursor.getColumnIndex("strPkgName"));
      paramEntity.strResName = paramCursor.getString(paramCursor.getColumnIndex("strResName"));
      paramEntity.strResURL = paramCursor.getString(paramCursor.getColumnIndex("strResURL"));
      paramEntity.uiCurVer = paramCursor.getLong(paramCursor.getColumnIndex("uiCurVer"));
      paramEntity.sLanType = paramCursor.getShort(paramCursor.getColumnIndex("sLanType"));
      paramEntity.strGotoUrl = paramCursor.getString(paramCursor.getColumnIndex("strGotoUrl"));
      paramEntity.sResSubType = paramCursor.getShort(paramCursor.getColumnIndex("sResSubType"));
      paramEntity.sPriority = paramCursor.getShort(paramCursor.getColumnIndex("sPriority"));
      paramEntity.strResSimpleDesc = paramCursor.getString(paramCursor.getColumnIndex("strResSimpleDesc"));
      paramEntity.strResDesc = paramCursor.getString(paramCursor.getColumnIndex("strResDesc"));
      paramEntity.uiResId = paramCursor.getLong(paramCursor.getColumnIndex("uiResId"));
      paramEntity.cDefaultState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDefaultState")));
      paramEntity.cCanChangeState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cCanChangeState")));
      paramEntity.isNew = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isNew")));
      paramEntity.cDataType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDataType")));
      paramEntity.cLocalState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cLocalState")));
      paramEntity.iPluginType = paramCursor.getInt(paramCursor.getColumnIndex("iPluginType"));
      paramEntity.timeStamp = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
      paramEntity.strNewPluginDesc = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginDesc"));
      paramEntity.strNewPluginURL = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginURL"));
      paramEntity.lebaSearchResultType = paramCursor.getInt(paramCursor.getColumnIndex("lebaSearchResultType"));
      paramEntity.pluginSetTips = paramCursor.getString(paramCursor.getColumnIndex("pluginSetTips"));
      paramEntity.pluginBg = paramCursor.getString(paramCursor.getColumnIndex("pluginBg"));
      paramEntity.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("strPkgName");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPkgName", String.class));
      i = paramCursor.getColumnIndex("strResName");
      if (i != -1) {
        break label1296;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResName", String.class));
      label517:
      i = paramCursor.getColumnIndex("strResURL");
      if (i != -1) {
        break label1311;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResURL", String.class));
      label551:
      i = paramCursor.getColumnIndex("uiCurVer");
      if (i != -1) {
        break label1326;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uiCurVer", Long.TYPE));
      label586:
      i = paramCursor.getColumnIndex("sLanType");
      if (i != -1) {
        break label1341;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sLanType", Short.TYPE));
      label621:
      i = paramCursor.getColumnIndex("strGotoUrl");
      if (i != -1) {
        break label1356;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGotoUrl", String.class));
      label655:
      i = paramCursor.getColumnIndex("sResSubType");
      if (i != -1) {
        break label1371;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sResSubType", Short.TYPE));
      label690:
      i = paramCursor.getColumnIndex("sPriority");
      if (i != -1) {
        break label1386;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sPriority", Short.TYPE));
      label725:
      i = paramCursor.getColumnIndex("strResSimpleDesc");
      if (i != -1) {
        break label1401;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResSimpleDesc", String.class));
      label759:
      i = paramCursor.getColumnIndex("strResDesc");
      if (i != -1) {
        break label1416;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResDesc", String.class));
      label793:
      i = paramCursor.getColumnIndex("uiResId");
      if (i != -1) {
        break label1431;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uiResId", Long.TYPE));
      label828:
      i = paramCursor.getColumnIndex("cDefaultState");
      if (i != -1) {
        break label1446;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cDefaultState", Byte.TYPE));
      label863:
      i = paramCursor.getColumnIndex("cCanChangeState");
      if (i != -1) {
        break label1462;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cCanChangeState", Byte.TYPE));
      label898:
      i = paramCursor.getColumnIndex("isNew");
      if (i != -1) {
        break label1478;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isNew", Byte.TYPE));
      label933:
      i = paramCursor.getColumnIndex("cDataType");
      if (i != -1) {
        break label1494;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cDataType", Byte.TYPE));
      label968:
      i = paramCursor.getColumnIndex("cLocalState");
      if (i != -1) {
        break label1510;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cLocalState", Byte.TYPE));
      label1003:
      i = paramCursor.getColumnIndex("iPluginType");
      if (i != -1) {
        break label1526;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iPluginType", Integer.TYPE));
      label1038:
      i = paramCursor.getColumnIndex("timeStamp");
      if (i != -1) {
        break label1541;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timeStamp", Long.TYPE));
      label1073:
      i = paramCursor.getColumnIndex("strNewPluginDesc");
      if (i != -1) {
        break label1556;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNewPluginDesc", String.class));
      label1107:
      i = paramCursor.getColumnIndex("strNewPluginURL");
      if (i != -1) {
        break label1571;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNewPluginURL", String.class));
      label1141:
      i = paramCursor.getColumnIndex("lebaSearchResultType");
      if (i != -1) {
        break label1586;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lebaSearchResultType", Integer.TYPE));
      label1176:
      i = paramCursor.getColumnIndex("pluginSetTips");
      if (i != -1) {
        break label1601;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pluginSetTips", String.class));
      label1210:
      i = paramCursor.getColumnIndex("pluginBg");
      if (i != -1) {
        break label1616;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pluginBg", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break label1631;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("flags", Integer.TYPE));
      return paramEntity;
      paramEntity.strPkgName = paramCursor.getString(i);
      break;
      label1296:
      paramEntity.strResName = paramCursor.getString(i);
      break label517;
      label1311:
      paramEntity.strResURL = paramCursor.getString(i);
      break label551;
      label1326:
      paramEntity.uiCurVer = paramCursor.getLong(i);
      break label586;
      label1341:
      paramEntity.sLanType = paramCursor.getShort(i);
      break label621;
      label1356:
      paramEntity.strGotoUrl = paramCursor.getString(i);
      break label655;
      label1371:
      paramEntity.sResSubType = paramCursor.getShort(i);
      break label690;
      label1386:
      paramEntity.sPriority = paramCursor.getShort(i);
      break label725;
      label1401:
      paramEntity.strResSimpleDesc = paramCursor.getString(i);
      break label759;
      label1416:
      paramEntity.strResDesc = paramCursor.getString(i);
      break label793;
      label1431:
      paramEntity.uiResId = paramCursor.getLong(i);
      break label828;
      label1446:
      paramEntity.cDefaultState = ((byte)paramCursor.getShort(i));
      break label863;
      label1462:
      paramEntity.cCanChangeState = ((byte)paramCursor.getShort(i));
      break label898;
      label1478:
      paramEntity.isNew = ((byte)paramCursor.getShort(i));
      break label933;
      label1494:
      paramEntity.cDataType = ((byte)paramCursor.getShort(i));
      break label968;
      label1510:
      paramEntity.cLocalState = ((byte)paramCursor.getShort(i));
      break label1003;
      label1526:
      paramEntity.iPluginType = paramCursor.getInt(i);
      break label1038;
      label1541:
      paramEntity.timeStamp = paramCursor.getLong(i);
      break label1073;
      label1556:
      paramEntity.strNewPluginDesc = paramCursor.getString(i);
      break label1107;
      label1571:
      paramEntity.strNewPluginURL = paramCursor.getString(i);
      break label1141;
      label1586:
      paramEntity.lebaSearchResultType = paramCursor.getInt(i);
      break label1176;
      label1601:
      paramEntity.pluginSetTips = paramCursor.getString(i);
      break label1210;
      label1616:
      paramEntity.pluginBg = paramCursor.getString(i);
    }
    label1631:
    paramEntity.flags = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ResourcePluginInfo)paramEntity;
    paramContentValues.put("strPkgName", paramEntity.strPkgName);
    paramContentValues.put("strResName", paramEntity.strResName);
    paramContentValues.put("strResURL", paramEntity.strResURL);
    paramContentValues.put("uiCurVer", Long.valueOf(paramEntity.uiCurVer));
    paramContentValues.put("sLanType", Short.valueOf(paramEntity.sLanType));
    paramContentValues.put("strGotoUrl", paramEntity.strGotoUrl);
    paramContentValues.put("sResSubType", Short.valueOf(paramEntity.sResSubType));
    paramContentValues.put("sPriority", Short.valueOf(paramEntity.sPriority));
    paramContentValues.put("strResSimpleDesc", paramEntity.strResSimpleDesc);
    paramContentValues.put("strResDesc", paramEntity.strResDesc);
    paramContentValues.put("uiResId", Long.valueOf(paramEntity.uiResId));
    paramContentValues.put("cDefaultState", Byte.valueOf(paramEntity.cDefaultState));
    paramContentValues.put("cCanChangeState", Byte.valueOf(paramEntity.cCanChangeState));
    paramContentValues.put("isNew", Byte.valueOf(paramEntity.isNew));
    paramContentValues.put("cDataType", Byte.valueOf(paramEntity.cDataType));
    paramContentValues.put("cLocalState", Byte.valueOf(paramEntity.cLocalState));
    paramContentValues.put("iPluginType", Integer.valueOf(paramEntity.iPluginType));
    paramContentValues.put("timeStamp", Long.valueOf(paramEntity.timeStamp));
    paramContentValues.put("strNewPluginDesc", paramEntity.strNewPluginDesc);
    paramContentValues.put("strNewPluginURL", paramEntity.strNewPluginURL);
    paramContentValues.put("lebaSearchResultType", Integer.valueOf(paramEntity.lebaSearchResultType));
    paramContentValues.put("pluginSetTips", paramEntity.pluginSetTips);
    paramContentValues.put("pluginBg", paramEntity.pluginBg);
    paramContentValues.put("flags", Integer.valueOf(paramEntity.flags));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResSimpleDesc TEXT ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     akvu
 * JD-Core Version:    0.7.0.1
 */