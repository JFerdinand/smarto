package com.slyak.smarto.service;

import com.slyak.smarto.domain.*;
import com.slyak.smarto.dto.BatchQuery;
import com.slyak.smarto.dto.SysEnv;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.Future;

/**
 * .
 *
 * @author stormning 2018/4/17
 * @since 1.3.0
 */
public interface SmartoManager {
    Page<Project> queryProjects(Pageable pageable);

    List<ScriptFile> findScriptFiles(Long scriptId);

    void saveScript(Script script);

    Page<Script> queryScripts(String keyword, Pageable pageable);

    void saveOs(OS os);

    void saveScriptFile(ScriptFile scriptFile);

    List<OS> queryOss();

    OS findOs(String osName);

    Future<Batch> execOwnerScripts(BatchOwner owner, Long ownerId);

    Global findGlobal();

    Global saveGlobal(Global global);

    Host getTestHost();

    boolean validateHost(Host host);

    String getBatchLogfile(Long batchId, Long hostId);

    Page<Batch> queryBatches(BatchQuery batchQuery, Pageable pageable);

    Page<Host> queryHosts(Pageable pageable);

    void saveHost(Host host);

    boolean validateHost(Host testHost, String command, String contains);

    List<SysEnv> querySysEnvs();

    Project saveProject(Project project);

    List<ProjectGroup> findProjectGroups(Long projectId);

    ProjectGroup saveProjectGroup(ProjectGroup projectGroup);

    List<Host> findHostsNotInProjectGroup(Long groupId);

    void addGroupHosts(Long groupId, List<Long> hostIds);

    void deleteProjectGroupHost(ProjectGroupHostKey id);

    List<ProjectGroupHost> findProjectGroupHosts(Long groupId);

    List<ProjectGroupScript> findProjectGroupScripts(Long groupId);

    void addGroupScripts(Long groupId, List<Long> scriptIds);

    void deleteProjectGroupScript(Long id);

    void saveGroupScript(ProjectGroupScript groupScript);

    void updateGroupOrders(List<Long> groupIds);

    void updateGroupScriptOrders(List<Long> groupScriptIds);

    void deleteProjectGroup(Long id);

    List<Project> findProjectsHavingScript(Long id);

    void deleteScript(Long id);

    void deleteScriptFile(ScriptFile scriptFile);

    void cleanUnusedFiles();

    void deleteProject(Long id);

    List<Mirror> queryMirrors();

    void saveMirror(Mirror mirror);

    void execProjectScripts(Long id);

    UserInfo queryByUserName(String userName);

    Page<UserInfo> queryUsers(Pageable pageable);

    List<SysRole> queryRoles();

    void saveUser(UserInfo userInfo);
}
