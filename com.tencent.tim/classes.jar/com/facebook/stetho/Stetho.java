package com.facebook.stetho;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.DumpappHttpSocketLikeHandler;
import com.facebook.stetho.dumpapp.DumpappSocketLikeHandler;
import com.facebook.stetho.dumpapp.Dumper;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.FilesDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.HprofDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.facebook.stetho.inspector.DevtoolsSocketHandler;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import com.facebook.stetho.inspector.database.DatabaseFilesProvider;
import com.facebook.stetho.inspector.database.DefaultDatabaseConnectionProvider;
import com.facebook.stetho.inspector.database.DefaultDatabaseFilesProvider;
import com.facebook.stetho.inspector.database.SqliteDatabaseDriver;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.DocumentProviderFactory;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.elements.android.AndroidDocumentProviderFactory;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.module.CSS;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.protocol.module.DOM;
import com.facebook.stetho.inspector.protocol.module.DOMStorage;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Debugger;
import com.facebook.stetho.inspector.protocol.module.HeapProfiler;
import com.facebook.stetho.inspector.protocol.module.Inspector;
import com.facebook.stetho.inspector.protocol.module.Network;
import com.facebook.stetho.inspector.protocol.module.Page;
import com.facebook.stetho.inspector.protocol.module.Profiler;
import com.facebook.stetho.inspector.protocol.module.Runtime;
import com.facebook.stetho.inspector.protocol.module.Worker;
import com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory;
import com.facebook.stetho.server.AddressNameHelper;
import com.facebook.stetho.server.LazySocketHandler;
import com.facebook.stetho.server.LocalSocketServer;
import com.facebook.stetho.server.ProtocolDetectingSocketHandler;
import com.facebook.stetho.server.ProtocolDetectingSocketHandler.AlwaysMatchMatcher;
import com.facebook.stetho.server.ProtocolDetectingSocketHandler.ExactMagicMatcher;
import com.facebook.stetho.server.ServerManager;
import com.facebook.stetho.server.SocketHandler;
import com.facebook.stetho.server.SocketHandlerFactory;
import com.facebook.stetho.server.SocketLikeHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public class Stetho
{
  public static DumperPluginsProvider defaultDumperPluginsProvider(Context paramContext)
  {
    return new Stetho.2(paramContext);
  }
  
  public static InspectorModulesProvider defaultInspectorModulesProvider(Context paramContext)
  {
    return new Stetho.3(paramContext);
  }
  
  public static void initialize(Initializer paramInitializer)
  {
    if (!ActivityTracker.get().beginTrackingIfPossible((Application)paramInitializer.mContext.getApplicationContext())) {
      LogUtil.w("Automatic activity tracking not available on this API level, caller must invoke ActivityTracker methods manually!");
    }
    paramInitializer.start();
  }
  
  public static void initializeWithDefaults(Context paramContext)
  {
    initialize(new Stetho.1(paramContext, paramContext));
  }
  
  public static InitializerBuilder newInitializerBuilder(Context paramContext)
  {
    return new InitializerBuilder(paramContext, null);
  }
  
  static class BuilderBasedInitializer
    extends Stetho.Initializer
  {
    @Nullable
    private final DumperPluginsProvider mDumperPlugins;
    @Nullable
    private final InspectorModulesProvider mInspectorModules;
    
    private BuilderBasedInitializer(Stetho.InitializerBuilder paramInitializerBuilder)
    {
      super();
      this.mDumperPlugins = paramInitializerBuilder.mDumperPlugins;
      this.mInspectorModules = paramInitializerBuilder.mInspectorModules;
    }
    
    @Nullable
    protected Iterable<DumperPlugin> getDumperPlugins()
    {
      if (this.mDumperPlugins != null) {
        return this.mDumperPlugins.get();
      }
      return null;
    }
    
    @Nullable
    protected Iterable<ChromeDevtoolsDomain> getInspectorModules()
    {
      if (this.mInspectorModules != null) {
        return this.mInspectorModules.get();
      }
      return null;
    }
  }
  
  public static final class DefaultDumperPluginsBuilder
  {
    private final Context mContext;
    private final Stetho.PluginBuilder<DumperPlugin> mDelegate = new Stetho.PluginBuilder(null);
    
    public DefaultDumperPluginsBuilder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private DefaultDumperPluginsBuilder provideIfDesired(DumperPlugin paramDumperPlugin)
    {
      this.mDelegate.provideIfDesired(paramDumperPlugin.getName(), paramDumperPlugin);
      return this;
    }
    
    public Iterable<DumperPlugin> finish()
    {
      provideIfDesired(new HprofDumperPlugin(this.mContext));
      provideIfDesired(new SharedPreferencesDumperPlugin(this.mContext));
      provideIfDesired(new CrashDumperPlugin());
      provideIfDesired(new FilesDumperPlugin(this.mContext));
      return this.mDelegate.finish();
    }
    
    public DefaultDumperPluginsBuilder provide(DumperPlugin paramDumperPlugin)
    {
      this.mDelegate.provide(paramDumperPlugin.getName(), paramDumperPlugin);
      return this;
    }
    
    public DefaultDumperPluginsBuilder remove(String paramString)
    {
      this.mDelegate.remove(paramString);
      return this;
    }
  }
  
  public static final class DefaultInspectorModulesBuilder
  {
    private final Application mContext;
    @Nullable
    private List<Database.DatabaseDriver> mDatabaseDrivers;
    @Nullable
    private DatabaseFilesProvider mDatabaseFilesProvider;
    private final Stetho.PluginBuilder<ChromeDevtoolsDomain> mDelegate = new Stetho.PluginBuilder(null);
    @Nullable
    private DocumentProviderFactory mDocumentProvider;
    @Nullable
    private RuntimeReplFactory mRuntimeRepl;
    
    public DefaultInspectorModulesBuilder(Context paramContext)
    {
      this.mContext = ((Application)paramContext.getApplicationContext());
    }
    
    private DefaultInspectorModulesBuilder provideIfDesired(ChromeDevtoolsDomain paramChromeDevtoolsDomain)
    {
      this.mDelegate.provideIfDesired(paramChromeDevtoolsDomain.getClass().getName(), paramChromeDevtoolsDomain);
      return this;
    }
    
    @Nullable
    private DocumentProviderFactory resolveDocumentProvider()
    {
      if (this.mDocumentProvider != null) {
        return this.mDocumentProvider;
      }
      if (Build.VERSION.SDK_INT >= 14) {
        return new AndroidDocumentProviderFactory(this.mContext);
      }
      return null;
    }
    
    @Deprecated
    public DefaultInspectorModulesBuilder databaseFiles(DatabaseFilesProvider paramDatabaseFilesProvider)
    {
      this.mDatabaseFilesProvider = paramDatabaseFilesProvider;
      return this;
    }
    
    public DefaultInspectorModulesBuilder documentProvider(DocumentProviderFactory paramDocumentProviderFactory)
    {
      this.mDocumentProvider = paramDocumentProviderFactory;
      return this;
    }
    
    public Iterable<ChromeDevtoolsDomain> finish()
    {
      provideIfDesired(new Console());
      provideIfDesired(new Debugger());
      Object localObject1 = resolveDocumentProvider();
      if (localObject1 != null)
      {
        localObject1 = new Document((DocumentProviderFactory)localObject1);
        provideIfDesired(new DOM((Document)localObject1));
        provideIfDesired(new CSS((Document)localObject1));
      }
      provideIfDesired(new DOMStorage(this.mContext));
      provideIfDesired(new HeapProfiler());
      provideIfDesired(new Inspector());
      provideIfDesired(new Network(this.mContext));
      provideIfDesired(new Page(this.mContext));
      provideIfDesired(new Profiler());
      Database localDatabase;
      label225:
      int j;
      Object localObject2;
      if (this.mRuntimeRepl != null)
      {
        localObject1 = this.mRuntimeRepl;
        provideIfDesired(new Runtime((RuntimeReplFactory)localObject1));
        provideIfDesired(new Worker());
        if (Build.VERSION.SDK_INT < 11) {
          break label335;
        }
        localDatabase = new Database();
        if (this.mDatabaseDrivers == null) {
          break label282;
        }
        localObject1 = this.mDatabaseDrivers.iterator();
        int i = 0;
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label284;
        }
        localObject2 = (Database.DatabaseDriver)((Iterator)localObject1).next();
        localDatabase.add((Database.DatabaseDriver)localObject2);
        if (!(localObject2 instanceof SqliteDatabaseDriver)) {
          break label358;
        }
        i = 1;
      }
      label282:
      label284:
      label335:
      label343:
      label358:
      for (;;)
      {
        break label225;
        localObject1 = new RhinoDetectingRuntimeReplFactory(this.mContext);
        break;
        j = 0;
        if (j == 0)
        {
          localObject2 = this.mContext;
          if (this.mDatabaseFilesProvider == null) {
            break label343;
          }
        }
        for (localObject1 = this.mDatabaseFilesProvider;; localObject1 = new DefaultDatabaseFilesProvider(this.mContext))
        {
          localDatabase.add(new SqliteDatabaseDriver((Context)localObject2, (DatabaseFilesProvider)localObject1, new DefaultDatabaseConnectionProvider()));
          provideIfDesired(localDatabase);
          return this.mDelegate.finish();
        }
      }
    }
    
    @Deprecated
    public DefaultInspectorModulesBuilder provide(ChromeDevtoolsDomain paramChromeDevtoolsDomain)
    {
      this.mDelegate.provide(paramChromeDevtoolsDomain.getClass().getName(), paramChromeDevtoolsDomain);
      return this;
    }
    
    public DefaultInspectorModulesBuilder provideDatabaseDriver(Database.DatabaseDriver paramDatabaseDriver)
    {
      if (this.mDatabaseDrivers == null) {
        this.mDatabaseDrivers = new ArrayList();
      }
      this.mDatabaseDrivers.add(paramDatabaseDriver);
      return this;
    }
    
    @Deprecated
    public DefaultInspectorModulesBuilder remove(String paramString)
    {
      this.mDelegate.remove(paramString);
      return this;
    }
    
    public DefaultInspectorModulesBuilder runtimeRepl(RuntimeReplFactory paramRuntimeReplFactory)
    {
      this.mRuntimeRepl = paramRuntimeReplFactory;
      return this;
    }
  }
  
  public static abstract class Initializer
  {
    private final Context mContext;
    
    protected Initializer(Context paramContext)
    {
      this.mContext = paramContext.getApplicationContext();
    }
    
    @Nullable
    protected abstract Iterable<DumperPlugin> getDumperPlugins();
    
    @Nullable
    protected abstract Iterable<ChromeDevtoolsDomain> getInspectorModules();
    
    final void start()
    {
      new ServerManager(new LocalSocketServer("main", AddressNameHelper.createCustomAddress("_devtools_remote"), new LazySocketHandler(new RealSocketHandlerFactory(null)))).start();
    }
    
    class RealSocketHandlerFactory
      implements SocketHandlerFactory
    {
      private RealSocketHandlerFactory() {}
      
      public SocketHandler create()
      {
        ProtocolDetectingSocketHandler localProtocolDetectingSocketHandler = new ProtocolDetectingSocketHandler(Stetho.Initializer.this.mContext);
        Object localObject = Stetho.Initializer.this.getDumperPlugins();
        if (localObject != null)
        {
          localObject = new Dumper((Iterable)localObject);
          localProtocolDetectingSocketHandler.addHandler(new ProtocolDetectingSocketHandler.ExactMagicMatcher(DumpappSocketLikeHandler.PROTOCOL_MAGIC), new DumpappSocketLikeHandler((Dumper)localObject));
          localObject = new DumpappHttpSocketLikeHandler((Dumper)localObject);
          localProtocolDetectingSocketHandler.addHandler(new ProtocolDetectingSocketHandler.ExactMagicMatcher("GET /dumpapp".getBytes()), (SocketLikeHandler)localObject);
          localProtocolDetectingSocketHandler.addHandler(new ProtocolDetectingSocketHandler.ExactMagicMatcher("POST /dumpapp".getBytes()), (SocketLikeHandler)localObject);
        }
        localObject = Stetho.Initializer.this.getInspectorModules();
        if (localObject != null) {
          localProtocolDetectingSocketHandler.addHandler(new ProtocolDetectingSocketHandler.AlwaysMatchMatcher(), new DevtoolsSocketHandler(Stetho.Initializer.this.mContext, (Iterable)localObject));
        }
        return localProtocolDetectingSocketHandler;
      }
    }
  }
  
  public static class InitializerBuilder
  {
    final Context mContext;
    @Nullable
    DumperPluginsProvider mDumperPlugins;
    @Nullable
    InspectorModulesProvider mInspectorModules;
    
    private InitializerBuilder(Context paramContext)
    {
      this.mContext = paramContext.getApplicationContext();
    }
    
    public Stetho.Initializer build()
    {
      return new Stetho.BuilderBasedInitializer(this, null);
    }
    
    public InitializerBuilder enableDumpapp(DumperPluginsProvider paramDumperPluginsProvider)
    {
      this.mDumperPlugins = ((DumperPluginsProvider)Util.throwIfNull(paramDumperPluginsProvider));
      return this;
    }
    
    public InitializerBuilder enableWebKitInspector(InspectorModulesProvider paramInspectorModulesProvider)
    {
      this.mInspectorModules = paramInspectorModulesProvider;
      return this;
    }
  }
  
  static class PluginBuilder<T>
  {
    private boolean mFinished;
    private final ArrayList<T> mPlugins = new ArrayList();
    private final Set<String> mProvidedNames = new HashSet();
    private final Set<String> mRemovedNames = new HashSet();
    
    private void throwIfFinished()
    {
      if (this.mFinished) {
        throw new IllegalStateException("Must not continue to build after finish()");
      }
    }
    
    public Iterable<T> finish()
    {
      this.mFinished = true;
      return this.mPlugins;
    }
    
    public void provide(String paramString, T paramT)
    {
      throwIfFinished();
      this.mPlugins.add(paramT);
      this.mProvidedNames.add(paramString);
    }
    
    public void provideIfDesired(String paramString, T paramT)
    {
      throwIfFinished();
      if ((!this.mRemovedNames.contains(paramString)) && (this.mProvidedNames.add(paramString))) {
        this.mPlugins.add(paramT);
      }
    }
    
    public void remove(String paramString)
    {
      throwIfFinished();
      this.mRemovedNames.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.Stetho
 * JD-Core Version:    0.7.0.1
 */