/*
 * This file is generated by jOOQ.
 */
package com.mycompany.myapp.database.tables;

import com.mycompany.myapp.database.DefaultSchema;
import com.mycompany.myapp.database.Keys;
import com.mycompany.myapp.database.tables.JhiAuthority.JhiAuthorityPath;
import com.mycompany.myapp.database.tables.JhiUserAuthority.JhiUserAuthorityPath;
import com.mycompany.myapp.database.tables.records.JhiUserRecord;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class JhiUser extends TableImpl<JhiUserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>jhi_user</code>
     */
    public static final JhiUser JHI_USER = new JhiUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JhiUserRecord> getRecordType() {
        return JhiUserRecord.class;
    }

    /**
     * The column <code>jhi_user.id</code>.
     */
    public final TableField<JhiUserRecord, Long> ID = createField(
        DSL.name("id"),
        SQLDataType.BIGINT.nullable(false).identity(true),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.login</code>.
     */
    public final TableField<JhiUserRecord, String> LOGIN = createField(
        DSL.name("login"),
        SQLDataType.VARCHAR(50).nullable(false),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.password_hash</code>.
     */
    public final TableField<JhiUserRecord, String> PASSWORD_HASH = createField(
        DSL.name("password_hash"),
        SQLDataType.VARCHAR(60).nullable(false),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.first_name</code>.
     */
    public final TableField<JhiUserRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>jhi_user.last_name</code>.
     */
    public final TableField<JhiUserRecord, String> LAST_NAME = createField(DSL.name("last_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>jhi_user.email</code>.
     */
    public final TableField<JhiUserRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(191), this, "");

    /**
     * The column <code>jhi_user.image_url</code>.
     */
    public final TableField<JhiUserRecord, String> IMAGE_URL = createField(DSL.name("image_url"), SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>jhi_user.activated</code>.
     */
    public final TableField<JhiUserRecord, Byte> ACTIVATED = createField(
        DSL.name("activated"),
        SQLDataType.TINYINT.nullable(false),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.lang_key</code>.
     */
    public final TableField<JhiUserRecord, String> LANG_KEY = createField(DSL.name("lang_key"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>jhi_user.activation_key</code>.
     */
    public final TableField<JhiUserRecord, String> ACTIVATION_KEY = createField(
        DSL.name("activation_key"),
        SQLDataType.VARCHAR(20),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.reset_key</code>.
     */
    public final TableField<JhiUserRecord, String> RESET_KEY = createField(DSL.name("reset_key"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>jhi_user.created_by</code>.
     */
    public final TableField<JhiUserRecord, String> CREATED_BY = createField(
        DSL.name("created_by"),
        SQLDataType.VARCHAR(50).nullable(false),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.created_date</code>.
     */
    public final TableField<JhiUserRecord, LocalDateTime> CREATED_DATE = createField(
        DSL.name("created_date"),
        SQLDataType.LOCALDATETIME(0),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.reset_date</code>.
     */
    public final TableField<JhiUserRecord, LocalDateTime> RESET_DATE = createField(
        DSL.name("reset_date"),
        SQLDataType.LOCALDATETIME(0),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.last_modified_by</code>.
     */
    public final TableField<JhiUserRecord, String> LAST_MODIFIED_BY = createField(
        DSL.name("last_modified_by"),
        SQLDataType.VARCHAR(50),
        this,
        ""
    );

    /**
     * The column <code>jhi_user.last_modified_date</code>.
     */
    public final TableField<JhiUserRecord, LocalDateTime> LAST_MODIFIED_DATE = createField(
        DSL.name("last_modified_date"),
        SQLDataType.LOCALDATETIME(0),
        this,
        ""
    );

    private JhiUser(Name alias, Table<JhiUserRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private JhiUser(Name alias, Table<JhiUserRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>jhi_user</code> table reference
     */
    public JhiUser(String alias) {
        this(DSL.name(alias), JHI_USER);
    }

    /**
     * Create an aliased <code>jhi_user</code> table reference
     */
    public JhiUser(Name alias) {
        this(alias, JHI_USER);
    }

    /**
     * Create a <code>jhi_user</code> table reference
     */
    public JhiUser() {
        this(DSL.name("jhi_user"), null);
    }

    public <O extends Record> JhiUser(
        Table<O> path,
        ForeignKey<O, JhiUserRecord> childPath,
        InverseForeignKey<O, JhiUserRecord> parentPath
    ) {
        super(path, childPath, parentPath, JHI_USER);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class JhiUserPath extends JhiUser implements Path<JhiUserRecord> {

        private static final long serialVersionUID = 1L;

        public <O extends Record> JhiUserPath(
            Table<O> path,
            ForeignKey<O, JhiUserRecord> childPath,
            InverseForeignKey<O, JhiUserRecord> parentPath
        ) {
            super(path, childPath, parentPath);
        }

        private JhiUserPath(Name alias, Table<JhiUserRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public JhiUserPath as(String alias) {
            return new JhiUserPath(DSL.name(alias), this);
        }

        @Override
        public JhiUserPath as(Name alias) {
            return new JhiUserPath(alias, this);
        }

        @Override
        public JhiUserPath as(Table<?> alias) {
            return new JhiUserPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<JhiUserRecord, Long> getIdentity() {
        return (Identity<JhiUserRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<JhiUserRecord> getPrimaryKey() {
        return Keys.KEY_JHI_USER_PRIMARY;
    }

    @Override
    public List<UniqueKey<JhiUserRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_JHI_USER_UX_USER_EMAIL, Keys.KEY_JHI_USER_UX_USER_LOGIN);
    }

    private transient JhiUserAuthorityPath _jhiUserAuthority;

    /**
     * Get the implicit to-many join path to the <code>jhi_user_authority</code>
     * table
     */
    public JhiUserAuthorityPath jhiUserAuthority() {
        if (_jhiUserAuthority == null) _jhiUserAuthority = new JhiUserAuthorityPath(this, null, Keys.FK_USER_ID.getInverseKey());

        return _jhiUserAuthority;
    }

    /**
     * Get the implicit many-to-many join path to the <code>jhi_authority</code>
     * table
     */
    public JhiAuthorityPath jhiAuthority() {
        return jhiUserAuthority().jhiAuthority();
    }

    @Override
    public JhiUser as(String alias) {
        return new JhiUser(DSL.name(alias), this);
    }

    @Override
    public JhiUser as(Name alias) {
        return new JhiUser(alias, this);
    }

    @Override
    public JhiUser as(Table<?> alias) {
        return new JhiUser(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JhiUser rename(String name) {
        return new JhiUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JhiUser rename(Name name) {
        return new JhiUser(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JhiUser rename(Table<?> name) {
        return new JhiUser(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JhiUser where(Condition condition) {
        return new JhiUser(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JhiUser where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JhiUser where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JhiUser where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JhiUser where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JhiUser where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JhiUser where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public JhiUser where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JhiUser whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public JhiUser whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
