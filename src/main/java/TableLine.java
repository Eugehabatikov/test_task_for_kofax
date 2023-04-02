import java.util.List;

public class TableLine {
    String DEL_FLAG;
    String SEED_VERSION_ADDED;
    String SEED_VERSION_UPDATED;
    String PREFERENCE_NAME;
    String DESCRIPTION;
    String SYSTEM_LEVEL_YN;
    String GROUP_LEVEL_YN;
    String USER_LEVEL_YN;
    String CHANGEABLE_YN;
    String PREFERENCE_DOMAIN_NAME;
    String USE_DEFAULT_VALUE_YN;
    String DEFAULT_VALUE;
    String GROUP_LEVEL_PRIORITY_YN;
    String GROUP_RESOLUTION_METHOD;
    String PRESERVE_ON_UPGRADE_YN;
    String MODULE_NAME;
    String ORG_LEVEL_YN;

    public TableLine(List rawData) {
        DEL_FLAG = rawData.get(0).toString().replace("\"", "").replace("\'", "\\'");
        SEED_VERSION_ADDED = rawData.get(1).toString().replace("\"", "").replace("\'", "\\'");
        SEED_VERSION_UPDATED = rawData.get(2).toString().replace("\"", "").replace("\'", "\\'");
        PREFERENCE_NAME = rawData.get(3).toString().replace("\"", "").replace("\'", "\\'");
        DESCRIPTION = rawData.get(4).toString().replace("\"", "").replace("\'", "\\'");
        SYSTEM_LEVEL_YN = rawData.get(5).toString().replace("\"", "").replace("\'", "\\'");
        GROUP_LEVEL_YN = rawData.get(6).toString().replace("\"", "").replace("\'", "\\'");
        USER_LEVEL_YN = rawData.get(7).toString().replace("\"", "").replace("\'", "\\'");
        CHANGEABLE_YN = rawData.get(8).toString().replace("\"", "").replace("\'", "\\'");
        PREFERENCE_DOMAIN_NAME = rawData.get(9).toString().replace("\"", "").replace("\'", "\\'");
        USE_DEFAULT_VALUE_YN = rawData.get(10).toString().replace("\"", "").replace("\'", "\\'");
        DEFAULT_VALUE = rawData.get(11).toString().replace("\"", "").replace("\'", "\\'");
        GROUP_LEVEL_PRIORITY_YN = rawData.get(12).toString().replace("\"", "").replace("\'", "\\'");
        GROUP_RESOLUTION_METHOD = rawData.get(13).toString().replace("\"", "").replace("\'", "\\'");
        PRESERVE_ON_UPGRADE_YN = rawData.get(14).toString().replace("\"", "").replace("\'", "\\'");
        MODULE_NAME = rawData.get(15).toString().replace("\"", "").replace("\'", "\\'");
        ORG_LEVEL_YN = rawData.get(16).toString().replace("\"", "").replace("\'", "\\'");
    }

    public static String inputValue(TableLine value) {
        return "'" + value.DEL_FLAG + "','" +
                value.SEED_VERSION_ADDED + "','" +
                value.SEED_VERSION_UPDATED + "','" +
                value.PREFERENCE_NAME + "','" +
                value.DESCRIPTION + "','" +
                value.SYSTEM_LEVEL_YN + "','" +
                value.GROUP_LEVEL_YN + "','" +
                value.USER_LEVEL_YN + "','" +
                value.CHANGEABLE_YN + "','" +
                value.PREFERENCE_DOMAIN_NAME + "','" +
                value.USE_DEFAULT_VALUE_YN + "','" +
                value.DEFAULT_VALUE + "','" +
                value.GROUP_LEVEL_PRIORITY_YN + "','" +
                value.GROUP_RESOLUTION_METHOD + "','" +
                value.PRESERVE_ON_UPGRADE_YN + "','" +
                value.MODULE_NAME + "','" +
                value.ORG_LEVEL_YN + "'";
    }
}
