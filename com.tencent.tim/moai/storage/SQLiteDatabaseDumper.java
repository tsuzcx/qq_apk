package moai.storage;

import android.util.PrintStreamPrinter;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.tencent.moai.database.sqlite.SQLiteDebug;

import java.util.List;

/**
 * Created by ayangxu.
 */
public class SQLiteDatabaseDumper implements DumperPlugin {
    @Override
    public String getName() {
        return "database";
    }

    @Override
    public void dump(DumperContext dumperContext) throws DumpException {
        PrintStreamPrinter writer = new PrintStreamPrinter(dumperContext.getStdout());
        List<String> args = dumperContext.getArgsAsList();
        SQLiteDebug.dump(writer, args.toArray(new String[args.size()]));
    }
}
