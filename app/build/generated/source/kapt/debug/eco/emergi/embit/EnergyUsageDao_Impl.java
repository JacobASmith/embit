package eco.emergi.embit;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EnergyUsageDao_Impl implements EnergyUsageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EnergyUsage> __insertionAdapterOfEnergyUsage;

  private final EntityDeletionOrUpdateAdapter<EnergyUsage> __deletionAdapterOfEnergyUsage;

  private final EntityDeletionOrUpdateAdapter<EnergyUsage> __updateAdapterOfEnergyUsage;

  private final SharedSQLiteStatement __preparedStmtOfDeleteEnergyUsage;

  public EnergyUsageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEnergyUsage = new EntityInsertionAdapter<EnergyUsage>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `EnergyUsage` (`id`,`amperage`,`voltage`,`time`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EnergyUsage value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getAmperage());
        stmt.bindLong(3, value.getVoltage());
        stmt.bindLong(4, value.getTime());
      }
    };
    this.__deletionAdapterOfEnergyUsage = new EntityDeletionOrUpdateAdapter<EnergyUsage>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `EnergyUsage` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EnergyUsage value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfEnergyUsage = new EntityDeletionOrUpdateAdapter<EnergyUsage>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `EnergyUsage` SET `id` = ?,`amperage` = ?,`voltage` = ?,`time` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EnergyUsage value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getAmperage());
        stmt.bindLong(3, value.getVoltage());
        stmt.bindLong(4, value.getTime());
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteEnergyUsage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM energyusage WHERE amperage=? AND voltage=? AND time=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EnergyUsage energyUsage) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEnergyUsage.insert(energyUsage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final EnergyUsage energyUsage) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEnergyUsage.handle(energyUsage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EnergyUsage energyUsage) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEnergyUsage.handle(energyUsage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteEnergyUsage(final long amps, final int volts, final long time) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteEnergyUsage.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, amps);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, volts);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, time);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteEnergyUsage.release(_stmt);
    }
  }

  @Override
  public EnergyUsage getEnergyUsage(final long amps, final int volts, final long time) {
    final String _sql = "SELECT * FROM energyusage WHERE amperage=? AND voltage=? AND time=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, amps);
    _argIndex = 2;
    _statement.bindLong(_argIndex, volts);
    _argIndex = 3;
    _statement.bindLong(_argIndex, time);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAmperage = CursorUtil.getColumnIndexOrThrow(_cursor, "amperage");
      final int _cursorIndexOfVoltage = CursorUtil.getColumnIndexOrThrow(_cursor, "voltage");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final EnergyUsage _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final long _tmpAmperage;
        _tmpAmperage = _cursor.getLong(_cursorIndexOfAmperage);
        final int _tmpVoltage;
        _tmpVoltage = _cursor.getInt(_cursorIndexOfVoltage);
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        _result = new EnergyUsage(_tmpId,_tmpAmperage,_tmpVoltage,_tmpTime);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<List<EnergyUsage>> getAllEnergyUsageData() {
    final String _sql = "SELECT * FROM energyusage";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"energyusage"}, new Callable<List<EnergyUsage>>() {
      @Override
      public List<EnergyUsage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAmperage = CursorUtil.getColumnIndexOrThrow(_cursor, "amperage");
          final int _cursorIndexOfVoltage = CursorUtil.getColumnIndexOrThrow(_cursor, "voltage");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final List<EnergyUsage> _result = new ArrayList<EnergyUsage>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EnergyUsage _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final long _tmpAmperage;
            _tmpAmperage = _cursor.getLong(_cursorIndexOfAmperage);
            final int _tmpVoltage;
            _tmpVoltage = _cursor.getInt(_cursorIndexOfVoltage);
            final long _tmpTime;
            _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            _item = new EnergyUsage(_tmpId,_tmpAmperage,_tmpVoltage,_tmpTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
