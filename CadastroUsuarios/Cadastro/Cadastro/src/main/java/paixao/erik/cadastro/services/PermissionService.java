package paixao.erik.cadastro.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paixao.erik.cadastro.entity.PermissionEntity;
import paixao.erik.cadastro.util.GenericService;
import paixao.erik.cadastro.util.ServicePath;

@RestController
@RequestMapping(path = ServicePath.PERMISSION_PATH)
public class PermissionService extends GenericService<PermissionEntity, Long> {

}