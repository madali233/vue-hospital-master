import http from '@/utils/request'

export function getRoutes() {

}

/**
* 查询角色列表
* @returns
*/
export async function getRoles(params) {
  return await http.get("/api/role/list", params);

}
/**
* 添加角色
* @returns
*/
export async function addRole(params) {
  return await http.post("/api/role/add", params);
}
/**
* 编辑角色
* @returns
*/
export async function updateRole(params) {
  return await http.put("/api/role/update", params);
}

export function deleteRole(id) {

}

/**
* 查询分配权限树列表
* @returns
*/
export async function getAssignTreeApi(params){
return await http.get("/api/role/getAssignPermissionTree",params);
}

/**
* 分配权限
* @returns
*/
export async function assignSaveApi(params){
  return await http.post("/api/role/saveRoleAssign",params);
}
  