import android.content.Context;
import android.content.Intent;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;

class aidg
  implements aidq.a
{
  aidg(aidf paramaidf) {}
  
  public void k(int paramInt, Object... paramVarArgs)
  {
    Intent localIntent = new Intent(aidi.lu(aidf.a(this.b)));
    localIntent.putExtra("key_state", paramInt);
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        aidf.a(this.b).sendBroadcast(localIntent);
        return;
        localIntent.putExtra("key_totalSize", ((Long)paramVarArgs[0]).longValue());
        continue;
        paramInt = ((Integer)paramVarArgs[0]).intValue();
        localIntent.putExtra("key_totalSize", ((Long)paramVarArgs[1]).longValue());
        localIntent.putExtra("key_progress", paramInt);
        continue;
        localIntent.putExtra("key_installedplugin", (InstalledPlugin)paramVarArgs[0]);
        if (aidi.mU(aidf.a(this.b)))
        {
          aids.Lb("2691709");
        }
        else if (aidi.mV(aidf.a(this.b)))
        {
          aids.Lb("2597857");
          continue;
          localIntent.putExtra("key_error_msg", (String)paramVarArgs[0]);
          if (aidi.mU(aidf.a(this.b)))
          {
            aids.Lb("2691710");
          }
          else if (aidi.mV(aidf.a(this.b)))
          {
            aids.Lb("2597858");
            continue;
            if ("download".equals(aidf.b(this.b)))
            {
              InstalledPlugin localInstalledPlugin = (InstalledPlugin)paramVarArgs[0];
              boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
              long l = ((Long)paramVarArgs[2]).longValue();
              aidf.a(this.b, localInstalledPlugin, bool, l);
            }
            if (aidi.mU(aidf.a(this.b)))
            {
              aids.Lb("2691703");
            }
            else if (aidi.mV(aidf.a(this.b)))
            {
              aids.Lb("2597720");
              continue;
              localIntent.putExtra("key_error_msg", (String)paramVarArgs[0]);
              if (aidi.mU(aidf.a(this.b))) {
                aids.Lb("2691704");
              } else if (aidi.mV(aidf.a(this.b))) {
                aids.Lb("2597721");
              }
            }
          }
        }
      }
    }
    aidf.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidg
 * JD-Core Version:    0.7.0.1
 */